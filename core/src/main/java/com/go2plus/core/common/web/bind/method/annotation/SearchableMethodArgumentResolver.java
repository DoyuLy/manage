package com.go2plus.core.common.web.bind.method.annotation;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.MethodParameter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.go2plus.core.common.entity.search.Searchable;
import com.go2plus.core.common.web.bind.annotation.SearchableDefaults;
import com.google.common.collect.Lists;


public class SearchableMethodArgumentResolver extends BaseMethodArgumentResolver {

    private static final String DEFAULT_SEARCH_PREFIX = "search";

    private String prefix = DEFAULT_SEARCH_PREFIX;

    /**
     * 设置查询参数前缀
     *
     * @param prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Searchable.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String searchPrefix = getSearchPrefix(parameter);

        Map<String, String[]> searcheableMap = getPrefixParameterMap(searchPrefix, webRequest, true);

        boolean hasCustomSearchFilter = searcheableMap.size() > 0;

        SearchableDefaults searchDefaults = getSearchableDefaults(parameter);

        boolean needMergeDefault = searchDefaults != null && searchDefaults.merge();

        Searchable searchable = null;
        //自定义覆盖默认
        if (needMergeDefault || !hasCustomSearchFilter) {
          searchable = getDefaultFromAnnotation(searchDefaults);
        }
        if (hasCustomSearchFilter) {
            if (searchable == null) {
              searchable = Searchable.newSearchable();
            }
            for (String name : searcheableMap.keySet()) {
                String[] mapValues = filterSearchValues(searcheableMap.get(name));

                if (mapValues.length == 1) {
                  searchable.addSearchParam(name, mapValues[0]);
                } else {
                    searchable.addSearchParam(name, mapValues);
                }
            }
        }

        
        return searchable;
    }

    private String[] filterSearchValues(String[] values) {
        List<String> result = Lists.newArrayList(CollectionUtils.arrayToList(values));
        for (int i = 0; i < result.size(); i++) {
            if (StringUtils.isBlank(result.get(i))) {
                result.remove(i);
            }
        }
        return result.toArray(values);
    }

    private String getSearchPrefix(MethodParameter parameter) {
        Qualifier qualifier = parameter.getParameterAnnotation(Qualifier.class);

        if (qualifier != null) {
            return new StringBuilder(((Qualifier) qualifier).value()).append("_").append(prefix).toString();
        }

        return prefix;
    }


    private SearchableDefaults getSearchableDefaults(MethodParameter parameter) {
        //首先从参数上找
        SearchableDefaults searchDefaults = parameter.getParameterAnnotation(SearchableDefaults.class);
        //找不到从方法上找
        if (searchDefaults == null) {
            searchDefaults = parameter.getMethodAnnotation(SearchableDefaults.class);
        }
        return searchDefaults;
    }


    private Searchable getDefaultFromAnnotation(SearchableDefaults searchableDefaults) {

      Searchable searchable = defaultSearchable(searchableDefaults);
        if (searchable != null) {
            return searchable;
        }

        return Searchable.newSearchable();
    }

    private Searchable defaultSearchable(SearchableDefaults searchableDefaults) {

        if (searchableDefaults == null) {
            return null;
        }

        Searchable searchable = Searchable.newSearchable();
        for (String searchParam : searchableDefaults.value()) {
            String[] searchPair = searchParam.split("=");
            String paramName = searchPair[0];
            String paramValue = searchPair[1];
            searchable.addSearchParam(paramName, paramValue);
        }

        return searchable;
    }

}

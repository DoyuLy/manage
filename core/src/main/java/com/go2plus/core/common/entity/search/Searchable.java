package com.go2plus.core.common.entity.search;

import java.util.Map;

/**
 * <p>查询条件接口</p>
 * <p>User: mtwu
 * <p>Date: 13-1-16 上午8:47
 * <p>Version: 1.0
 */
public abstract class Searchable {


    /**
     * 创建一个新的查询
     *
     * @return
     */
    public static Searchable newSearchable() {
        return new SearchRequest();
    }

    /**
     * 创建一个新的查询
     *
     * @return
     */
    public static Searchable newSearchable(final Map<String, Object> searchParams){
        return new SearchRequest(searchParams);
    }

    public abstract Searchable addSearchParam(final String key, final Object value);
    
    public abstract Searchable addSearchParams(Map<String, Object> searchParams);

    public abstract Map<String,Object> getSearchFilters();
    
    public abstract Searchable removeSearchFilter(final String key);


    public abstract boolean hasSearchFilter();

    
 
    public abstract boolean containsSearchKey(String key);

    

    public abstract Object getValue(String key);


    
   


}

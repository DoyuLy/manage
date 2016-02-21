package com.go2plus.core.common.entity.search;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * <p>查询条件（包括分页和排序）</p>
 * <p>User: mtwu
 * <p>Date: 13-1-15 上午7:29
 * <p>Version: 1.0
 */

public final class SearchRequest extends Searchable {

    private final Map<String, Object> searchFilterMap = Maps.newHashMap();
    
    /**
     * @param searchParams
     * @see SearchRequest#SearchRequest(java.util.Map<java.lang.String,java.lang.Object>)
     */
    public SearchRequest(final Map<String, Object> searchParams) {
      searchFilterMap.putAll(searchParams);
    }

    public SearchRequest() {
    }
    
    @Override
    public Map<String,Object> getSearchFilters(){
      return searchFilterMap;
    }
    
    @Override
    public Searchable addSearchParam(final String key, final Object value) {
        searchFilterMap.put(key, value);
        return this;
    }

    @Override
    public Searchable addSearchParams(Map<String, Object> searchParams) {
      searchFilterMap.putAll(searchParams);
        return this;
    }


    
    /**
     * @param key
     * @return
     */
    @Override
    public Searchable removeSearchFilter(final String key) {
        if (key == null) {
            return this;
        }
        searchFilterMap.remove(key);

        return this;
    }


    

    @Override
    public boolean hasSearchFilter() {
        return searchFilterMap.size() > 0;
    }

    
    @Override
    public boolean containsSearchKey(String key) {
        boolean contains =
                searchFilterMap.containsKey(key);

        return true;
    }

    

    @Override
    public Object getValue(String key) {
        Object searchFilter = searchFilterMap.get(key);
        
        return searchFilter;
    }


    
    @Override
    public String toString() {
        return "SearchRequest{" +
                "searchFilterMap=" + searchFilterMap +
                '}';
    }
}

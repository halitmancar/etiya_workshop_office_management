package com.etiya.office_management.core.ccc.caching;

public interface ICaching {
    void cache(String key, Object data);
    void cacheBreak(String key);
    Object get(String key);
}

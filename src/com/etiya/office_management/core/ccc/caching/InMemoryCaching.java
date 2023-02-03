package com.etiya.office_management.core.ccc.caching;

import java.util.HashMap;

public class InMemoryCaching implements ICaching{

    private HashMap objects;

    public InMemoryCaching() {
        this.objects = new HashMap();
    }

    @Override
    public void cache(String key, Object data) {
        System.out.println(key + "verisi cacheleniyor...");
        objects.put(key, data);
    }

    @Override
    public void cacheBreak(String key) {
        objects.remove(key);
    }

    @Override
    public Object get(String key) {
        return objects.get(key);
    }
}

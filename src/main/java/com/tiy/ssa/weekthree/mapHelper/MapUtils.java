package com.tiy.ssa.weekthree.mapHelper;

import java.util.HashMap;
import java.util.Map;

public class MapUtils<K, V> {
    
    final Map<K, V> map = new HashMap<>();

    public MapUtils(){}
    
    void add(K key, V value)
    {
        this.map.put(key, value);
    }
    
    public V getOrDefault(K key, V value)
    {
        V retValue = this.map.get(key);
        if(retValue != null) return retValue;
     
    return value;
    }
}

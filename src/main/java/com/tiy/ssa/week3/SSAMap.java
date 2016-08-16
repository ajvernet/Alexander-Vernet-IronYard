package com.tiy.ssa.week3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class SSAMap<K, V> implements Map<K, V>
{

    @Override
    public abstract V get(Object key);
    
    @Override
    public abstract V put(K key, V value);
    
    @Override
    public abstract V remove(Object key);
    
    @Override
    public abstract Set<java.util.Map.Entry<K, V>> entrySet();
    
    @Override
    public Set<K> keySet() {
        
        Set<K> keys = new HashSet<>();
        for(Entry<K,V> e: entrySet()){
            keys.add(e.getKey());
        }
        
        return keys;
    }
  
    @Override
    public void clear() {
        
 
        Iterator<K> itr = keySet().iterator();
        while(itr.hasNext()) remove(itr.next());
    }
    
    @Override
    public boolean containsValue(Object value)
    {
        return (values().contains(value));
    }
    
    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }
    
    @Override
    public void putAll(Map<? extends K, ? extends V> m) 
    {
        for(Entry<? extends K,? extends V> e: m.entrySet()){
            put(e.getKey(), e.getValue());            
        }        
    }
    
    @Override
    public int size() {
        return entrySet().size();
    }
    
    @Override
    public Collection<V> values() {
        Collection<V> valueList = new ArrayList<>();
        
        for(Entry<K,V> e: entrySet()){
            valueList.add(e.getValue());
        }
        
        return valueList;
    }
    
    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }
    
    @Override
    public V replace(K key, V value) {
      
        return (get(key) != null) ? put(key, value) : null;
    }
}

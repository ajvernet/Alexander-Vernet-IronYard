package com.tiy.ssa.week3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.week3.MapProject.DecoratorSSAMap;

public class TestSSAMap {

    DecoratorSSAMap<Integer, String> testDecMap = new DecoratorSSAMap<>();
   
    
    @Before
    public void setup(){
        testDecMap.put(1,  "First");
        testDecMap.put(2,  "Second");
        testDecMap.put(3, "Third");
        testDecMap.put(4, "Fourth");
    }
    
    @After
    public void reset(){
        testDecMap.clear();
    }
    
    @Test
    public void testSize(){
        assertEquals(4,  testDecMap.size());
    }
    
    @Test
    public void testContainsValue() {

        System.out.println(testDecMap.entrySet());
        System.out.println(testDecMap.get(10));
        
        System.out.println(testDecMap.values());
        assertTrue(testDecMap.containsValue("First"));
    }
    
    @Test
    public void testContainsKey(){
        assertTrue(testDecMap.containsKey(1));
    }
    
    @Test
    public void testPutAll(){
        DecoratorSSAMap<Integer, String> testMap2 = new DecoratorSSAMap<>();
        testMap2.put(1, "Very First");
        testMap2.put(5, "Fifth");
        
        testDecMap.putAll(testMap2);
        
        assertEquals("Very First", testDecMap.get(1));
        assertEquals("Fifth", testDecMap.get(5));
    }
    
    @Test
    public void testReplace(){
        assertEquals("Second", testDecMap.replace(2, "Two"));
        assertEquals("Two", testDecMap.get(2));
        
    }
    
    @Test
    public void testClear(){
        testDecMap.clear();
        assertEquals(0, testDecMap.size());
    }
}

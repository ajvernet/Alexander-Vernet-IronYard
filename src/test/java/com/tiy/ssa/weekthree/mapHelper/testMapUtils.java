package com.tiy.ssa.weekthree.mapHelper;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weekthree.mapHelper.MapUtils;

public class testMapUtils{

    MapUtils<Integer, String> testUtils = new MapUtils<>();
    
    
    Map<Integer, String> testMap = new HashMap<>();
    
  
    
    @Test
    public void test() {
        fail("Not yet implemented");
    }
    
    @Before
    public void setup(){
        testMap.put(1, "first");
        testMap.put(2,  "Second");
        testMap.put(3, "third");
        
        testUtils.
     
    }
    
    @Test
    public void testGetOrDefault(){
        assertEquals("fourth", )
    }

}

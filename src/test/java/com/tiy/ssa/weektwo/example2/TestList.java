package com.tiy.ssa.weektwo.example2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {
    List<String> listA = new ArrayList<>();
    List<String> listB = new ArrayList<>();
    
    @Before
    public void init(){

        
        listA.add("Peter");
        listA.add("Piper");
        listA.add("picked");
        listA.add("a");
        listA.add("peck");
        
 
        
        listB.add("If");
        listB.add("Peter");
        listB.add("Piper");
        listB.add("picked");
        listB.add("a");
        listB.add("peck");
    }
    
    @After
    public void clear(){
        listA.clear();
        listB.clear();
    }
    

    @Test
    public void testMatch(){
        List<String> listC = Lists.match(listA, listB);
        System.out.println(listC.toString());
        
        assertTrue(listA.containsAll(listC) && listB.containsAll(listC));
        
    }
    
    @Test
    public void testSortByDescending(){
        Lists.descendingBySize(listA);
        System.out.println(listA.toString());
        
        for(int i = 1; i < listA.size(); i++){
            
            assertTrue(listA.get(i).length() <= listA.get(i - 1).length());
        }
    }

}

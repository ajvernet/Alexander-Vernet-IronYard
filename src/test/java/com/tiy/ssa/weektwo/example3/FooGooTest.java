package com.tiy.ssa.weektwo.example3;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class FooGooTest {
    Foo foo1;
 https://github.com/jbrown762/Joseph-Brown-IronYard/blob/09395f2910eb8bac64e4b67772241e649fe8cac8/src/main/java/com/tiy/ssa/week3/assignment4/Trie/Text9Trie.java   Foo foo2;
    
    Goo goo1;
    Goo goo2;
    
    Set<Foo> fooSet = new HashSet<>();
    Set<Goo> gooSet = new HashSet<>();
    
    @Before
    public void setup(){
       
     = new Foo("Value");
    Foo foo2 = new Foo("Value");
       
    fooSet.add(foo1);
    fooSet.add(foo2);
    
    Goo goo1 = new Goo("Word");
    Goo goo2 = new Goo("Word");
    
    gooSet.add(goo1);
    gooSet.add(goo2);    
    }
    

    @Test
    public void fooEquals(){
    assertTrue(fooSet..equals(foo2));
    System.out.println(foo1.equals(foo2));  
    }
    
    @Test
    public void fooHash(){
        System.out.println(foo1.hashCode());
    }
    
    @Test
    public void gooHash(){
        System.out.println(goo1.hashCode());
    }
    
    @Test
    public void gooEquals(){
    assertTrue(goo1.equals(goo2));
    System.out.println(goo1.equals(goo2));
    }
}

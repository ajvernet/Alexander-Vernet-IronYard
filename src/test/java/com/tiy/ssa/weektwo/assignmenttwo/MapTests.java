package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tiy.ssa.weektwo.examplefive.SocialSecurityNumber;

public class MapTests {
    
    Map<SocialSecurityNumber, Name> map = new HashMap<>();
    
    @Before
    public void setup(){
        map.put(new SocialSecurityNumber("123456789"), new Name("Aristotle", "Plato"));
        map.put(new SocialSecurityNumber("123456788"), new Name("Jim", "Plato"));
        map.put(new SocialSecurityNumber("123456787"), new Name("Harry", "Plato"));
        map.put(new SocialSecurityNumber("123456786"), new Name("Dave", "Plato"));
        map.put(new SocialSecurityNumber("123456785"), new Name("Billy", "Plato"));
        map.put(new SocialSecurityNumber("123456784"), new Name("Kevin", "Plato"));
        map.put(new SocialSecurityNumber("123456783"), new Name("Daniel", "Plato"));
        map.put(new SocialSecurityNumber("123456781"), new Name("Ted", "Plato"));s
    }
    
    @After
    public void clearMap(){
        map.clear();
    }
    
    @Test
    public void initial(){

        map.put(new SocialSecurityNumber("123456789"), new Name("Aristotle", "Plato"));
        assertEquals("", new Name("Aristotle", "Plato"), map.get(new SocialSecurityNumber("123456789")));
        
        Name removed = map.remove(new SocialSecurityNumber("123456789"));
        

    }
    
    
}

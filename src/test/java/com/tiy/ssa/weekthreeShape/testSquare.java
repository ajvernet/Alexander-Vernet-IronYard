package com.tiy.ssa.weekthreeShape;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class testSquare {
    
    Square testSquare;
    @Before
    public void setup(){
        testSquare = new Square(5);
  
    }
    
    @Test
    public void testConstructor() {

        assertEquals(25,  testSquare.area(), 0);
    }

    @Test
    public void testSetBoth(){
        testSquare.setHeight(3);
        assertEquals(3, testSquare.getWidth(), 0);
        testSquare.setWidth(4);
        assertEquals(4,  testSquare.getHeight(), 0);
    }
    
}

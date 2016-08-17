package com.tiy.ssa.weektwo.factorial;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tiy.ssa.weektwo.factorial.Factorial;

public class FactorialTest {

    @Test
    public void testFactorial() {
        System.out.println(Factorial.factorial(100));
        System.out.println(Factorial.callCount);
        
        Factorial.callCount = 0;
        System.out.println(Factorial.factorial(100));
        System.out.println(Factorial.callCount);     
    }
    
    

}
package com.tiy.weektwoo.factorial;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Factorial {
    
    static final Map<Integer, BigInteger> CACHE = new HashMap<>();
    static int callCount = 0;
    
    private Factorial(){};
    
    public static BigInteger factorial(int input){
        
        callCount++;
        
        if(input == 1) return BigInteger.ONE;   
        
        if(CACHE.containsKey(input)) return CACHE.get(input);
        
        CACHE.put(input, factorial(input - 1).multiply(BigInteger.valueOf(input)));
        
        return factorial(input - 1).multiply(BigInteger.valueOf(input));
    }
}

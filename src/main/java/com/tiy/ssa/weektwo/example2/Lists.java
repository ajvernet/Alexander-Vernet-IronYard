package com.tiy.ssa.weektwo.example2;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    
    public static <T> List<T> match(List<T> listA, List<T> listB)
    {
        List<T> listC = new ArrayList<>();
        
        for(T t: listA){
            if (listB.contains(t))
                listC.add(t);
        }
        
        return listC; 
    }
    

    public static List<String> descendingBySize(List<String> input){
       input.sort((String s1, String s2) -> s2.length() - s1.length());
       return input;
    }
}

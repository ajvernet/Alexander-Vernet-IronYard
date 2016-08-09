package com.tiy.ssa.weektwo.example2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lists {

    
    public static <T> List<T> match(List<T> listA, List<T> listB)
    {
        Set<T> setC = new HashSet<>();
        
        for(T t: listA){
            if (listB.contains(t))
                setC.add(t);
        }
        
        List<T> listC = new ArrayList<>(setC);

        return listC;
    }
    

    public static List<String> descendingBySize(List<String> input){
       List<String> newList = new ArrayList<>(input);
       
       newList.sort((String s1, String s2) -> s2.length() - s1.length());
       return newList;
    }
}

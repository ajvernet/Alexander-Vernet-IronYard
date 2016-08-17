package com.tiy.ssa.weektwo.assignmentthree.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WordCount {
    
    private final ArrayList<String> source = new ArrayList<>();
    
    private final Map<String, Integer> wordMap = new HashMap<>();
    
    
    public void addWord(String word)
    {
        source.add(word + " ");
        if (wordMap.containsKey(word.toLowerCase()))
        wordMap.put(word.toLowerCase(), wordMap.get(word.toLowerCase()) + 1);
     
        else wordMap.put(word.toLowerCase(), 1);
    }

    public int count(String word)
    {
        
        return wordMap.get(word);
    }


    
    public List<String> top(int many)
    {              
        List<Integer> countList = new ArrayList<>(wordMap.values());
        countList.sort(Collections.reverseOrder());
      
        
        
        List<String> wordList = new ArrayList<>();
        
        

        for(Integer i: countList){
            for(Map.Entry<String, Integer> e: wordMap.entrySet()){
                if(e.getValue().equals(i) && !(wordList.contains(e.getKey()))) wordList.add(e.getKey());       
    
            }
        } 
        
        return (many > wordList.size()) ? wordList.subList(0, wordList.size()) : wordList.subList(0, many);
        
    }

    public V getOrDefault(K key, V def){
        
        
    }
    public List<String> bottom(int many)
    {
        List<Integer> countList = new ArrayList<>(wordMap.values());     
        Collections.sort(countList);
        
        List<String> wordList = new ArrayList<>();

        for(Integer i: countList){
            for(Map.Entry<String, Integer> e: wordMap.entrySet()){
                if(e.getValue().equals(i) && !(wordList.contains(e.getKey()))) wordList.add(e.getKey());       
            }
        } 
        
        return (many > wordList.size()) ? wordList.subList(0, wordList.size()) : wordList.subList(0, many);
    }

    /**
     *
     * @return the input that is being word counted (maintaining the order
     *         prescribed by {@link #addWord(String) }
     * @see #addWord(String)  
     */
    public String source()
    {
        return source.toString();
    }
}

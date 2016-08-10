package com.tiy.ssa.weektwo.assignmentthree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

    public class WordCountTests
    {
        static String SOURCE = "a1 a2 a2 a3 A3 A3 a4 A4 a4 a4. "
                + "b1 b2 B2 b3 b3 b3 b4 B4 B4 b4.";

        WordCount wordCount;

        @Before
        public void parse()
        {
            this.wordCount = new WordCount();
            String[] words = SOURCE.split("\\W+"); //should take care of punctuation and other special 
                                           //characters
            for (String word : words)
            {
                       this.wordCount.addWord(word);
            }
        }
        
        @Test
        public void testTopList(){
            List<String> topList = new ArrayList(Arrays.asList("a4", "b4", "a3", "b3"));
            System.out.println(wordCount.top(4));
           assertEquals(new HashSet(topList.subList(0, 2)), new HashSet(wordCount.top(4).subList(0, 2)));
           assertEquals(new HashSet(topList.subList(2, 4)), new HashSet(wordCount.top(4).subList(2, 4)));
        }
        
        @Test
        public void testBottomList(){
            List<String> bottomList = new ArrayList(Arrays.asList("a1", "b1", "a2", "b2"));
            System.out.println(wordCount.bottom(4));
            assertEquals(new HashSet(bottomList.subList(0, 2)), new HashSet(wordCount.bottom(4).subList(0, 2)));
            assertEquals(new HashSet(bottomList.subList(2, 4)), new HashSet(wordCount.bottom(4).subList(2, 4)));      
        }
        
        @Test
        public void testSource(){
          System.out.println(wordCount.source());
        
        }
        
        
        
}

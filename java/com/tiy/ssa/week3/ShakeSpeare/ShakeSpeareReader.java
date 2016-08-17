package com.tiy.ssa.week3.ShakeSpeare;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tiy.ssa.weektwo.assignmentthree.WordCount;

public class ShakeSpeareReader {

    WordCount counter = new WordCount();
    
    @Test
    public void justChecking() throws Exception
    {
        BufferedReader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get("C:/Users/admin/workspace/resources/the-complete-works.txt"),
                    Charset.defaultCharset());
            
            String line;
            int i = 0;
            
            while (null != (line = reader.readLine()) && i++ < 15)
            {
                String[] words = line.split("\\W+");
              //  System.out.println(line + ", ");
                for (String word : words)
                {
                    if(!word.isEmpty())
                    {
                       counter.addWord(word);
                    }
                }
            }
        } finally { reader.close();}
        
        System.err.println(counter.bottom(25));
        
        
        
    }
}

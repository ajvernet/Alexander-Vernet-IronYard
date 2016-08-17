package com.tiy.ssa.week3.cypher;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

import org.junit.Before;
import org.junit.Test;

public class cypherTest{
    
String path1;
String path2;
String path3;
String path4;
Byte[] bytes;

FileInputStream reader;

File file1;
File file2;
File file3;
File file4;

String d1;
String d2;
String d3;
String d4;

int read;
    
    @Before
    public void setup() throws Exception {
        path1 = "C:/Users/admin/workspace/Resources/eclipse-inst-win64.exe";
        file1 = new File(path1);
        reader = new FileInputStream(file1);
        
        read = 0;

        d1 = "SHA-1";
        d2 = "MD5";
        d3 = "SHA-256";
        d4 = "SHA-512";       
 
    }
    
    @Test
    public void fileExists(){
        assertTrue(file1.exists());
    }
    
    @Test
    public void testSHA_1(){
        
        String hashed = "21302bcf1d6d22ce3022af54f958649695afb84e38c8e640ea"
                + "fd7e64ba852ff3c13eae33db9e19affbc4e861341391143a40669da83"
                + "9c1bddcc8dea7240218e9";
        byte b1 = 40;
        FileSecureHash f1 = new FileSecureHash(path1, d4);
     //   System.out.println(f1.toBinary(b1));
//        System.out.println(f1.hash());
    }
    

    
    

}

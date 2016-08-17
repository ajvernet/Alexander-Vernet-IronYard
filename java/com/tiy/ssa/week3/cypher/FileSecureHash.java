package com.tiy.ssa.week3.cypher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Stack;

public class FileSecureHash implements FileVerifier {

    String filePath;
    String digestAlgorithm;

    public FileSecureHash(String filePath, String digestAlgorithm) {
        this.filePath = filePath;
        this.digestAlgorithm = digestAlgorithm;
    }

    public String toHex(byte[] digest) {

        StringBuilder sb = new StringBuilder();

        for (Byte b : digest)
            sb.append(String.format("%02X", b));

        return sb.toString();

    }


    String toBinary(byte[] b1){
        String binary = "";
        for(Byte b: b1){
            binary += " " + toBinary(b);
        }
        
        return binary;
    }
    
    String toBinary(byte b1){

        int[] binArray = new int[8];
        
        char[] byteChars = ((Byte)b1).toString().toCharArray();
        
        int num = b1;
        for(int i = 7; i > 0; i--){
            binArray[i] = (num % 2);  
            num /= 2;
        }
        
        if(byteChars[0] == '-'){
            
        for(int i = 7; i < 0; i--){
            if(binArray[i] == 1){
                for(int j = i - 1; i < 0; i--){
                    if (binArray[j] == 0) binArray[j] = 1;
                    else binArray[j] = 0;
                }
                
               return Arrays.toString(binArray);
            }
            
            }
        }
        return Arrays.toString(binArray); 
    }
    
    @Override
    public String hash() {

        try {
            MessageDigest md = MessageDigest.getInstance(digestAlgorithm);
            File file = new File(filePath);
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[1_024];

            int read;

            while ((read = input.read(bytes)) > 0) {
                md.update(bytes, 0, read);
            }

            byte[] digest = md.digest();
            
          
            return toHex(digest);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}

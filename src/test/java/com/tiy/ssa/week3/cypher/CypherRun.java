package com.tiy.ssa.week3.cypher;

import java.util.Scanner;

public class CypherRun {

    public static void main(String[] args) {
        
        
        
        FileSecureHash fileHash = new FileSecureHash(args[4], args[6]);
        
        if(args[7] != null && args[7] == "-u"){
            System.out.println(fileHash.hash().toUpperCase());
        }
        
        System.out.println(fileHash.hash());
        
    }
}

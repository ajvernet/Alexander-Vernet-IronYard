package com.tiy.ssa.weektwo.example4;

public class AssociativeGrammar {

    private String input;

    public AssociativeGrammer(String input){
        this.input = input;
    }
    
    public String getSource(){
        return input;
    }
    
    public String addOperator(char operator){
        return input += operator;
    }
    
    public boolean compiles(){
        
        char[] validChars = {'{', '}', '(', ')', '[', ']'};
        return false;
        
    }
}

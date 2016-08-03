package com.tiy.ssa.weekone.example3;

public class MaybePalindrome {

	final String value;
	
	public MaybePalindrome(String value){
		this.value = value;
	}
	
	public boolean isPalindrome(){
		
	String reverseString = createReverseString();
	
	return (value.equalsIgnoreCase(reverseString));
		
	}
	
	public String createReverseString(){
		
		char[] chars = value.toCharArray();
		char[] reverseChars = new char[chars.length];
		
		int j = chars.length - 1;
		
		for(char c: chars){
			
			reverseChars[j] = c;
			j--;		
				
			}
		
		return new String(reverseChars);
	}
	
	@Override
	public String toString(){
		return value + " is a palindrome: " + isPalindrome();
	}
	
}

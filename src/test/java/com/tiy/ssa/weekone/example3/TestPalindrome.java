package com.tiy.ssa.weekone.example3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalindrome {

	@Test
	public void testNotPalindrome(){
		
		assertFalse(new MaybePalindrome("Alexander").isPalindrome());
		
	}
	
	@Test
	public void testIsPalindrome() {
		
		assertTrue(new MaybePalindrome("mom").isPalindrome());
		
	}
	
	@Test
	public void testIsPalindromeDiffCase(){
		
		assertTrue(new MaybePalindrome("nOoN").isPalindrome());
		
	}
	
	@Test
	public void testToString(){
		
		MaybePalindrome stringTestIs = new MaybePalindrome("lol");
		System.out.println(stringTestIs.toString());
		
	}	
}

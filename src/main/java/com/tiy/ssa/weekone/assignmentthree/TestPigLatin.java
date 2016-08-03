package com.tiy.ssa.weekone.assignmentthree;

import static org.junit.Assert.*;

import org.junit.Test;

// Rule 1 - word begins with a vowel
// Rule 2 - word begins with two consonants
// Rule 3 - word begins with consonant and a vowel


public class TestPigLatin {

	@Test
	public void translateRule1SingleWord() {
		PigLatin test1 = new PigLatin("alpha");
		test1.translate();
		System.out.println(test1.pLatinWord);
		assertEquals("alphaway", test1.pLatinWord);
	}
	
	@Test
	public void translateRule1MultWords(){
		PigLatin test = new PigLatin("alpha eta");
		test.translate();
		assertEquals("alphaway etaway", test.pLatinWord);
		
	}
	
	@Test
	public void translateRule2SingleWord() {
		PigLatin test = new PigLatin("start");
		test.translate();
		System.out.println(test.pLatinWord);
		assertEquals("artstay", test.pLatinWord);
	}
	
	@Test
	public void translateRule2MultWords() {
		PigLatin test = new PigLatin("start slip");
		test.translate();
		assertEquals("artstay ipslay", test.pLatinWord);
	}
	
	@Test
	public void translateRule3SingleWord() {
		PigLatin test = new PigLatin("silly");
		test.translate();
		System.out.println(test.pLatinWord);
		assertEquals("illysay", test.pLatinWord);
	}
	
	@Test
	public void translateRule3MultWords() {
		PigLatin test = new PigLatin("silly billy");
		test.translate();
		assertEquals("illysay illybay", test.pLatinWord);
		
	}
	
	@Test
	public void translateSentence(){
		
		PigLatin test = new PigLatin("Please do not ask me to code this again");
		test.translate();
		System.out.println(test.pLatinWord);
		assertEquals("easePlay oday otnay askway emay otay odecay isthay againway", 
				test.pLatinWord);
		
	}
	
	

}

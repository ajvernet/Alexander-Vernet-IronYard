package com.tiy.ssa.weekone.assignmentthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PigLatin {

	final static ArrayList<Character> vowelList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	String word;
	String pLatinWord = "";

	StringBuilder wordBuilder;

	char[] charArray;

	public PigLatin(String word) {
		this.word = word;
		charArray = word.toCharArray();
	}

	public boolean firstCharIsVowel() {

		for (Character c : vowelList) {
			if (charArray[0] == c || charArray[0] == Character.toUpperCase(c))
				return true;
		}

		return false;
	}

	public boolean secondCharIsVowel() {

		for (Character c : vowelList) {
			if (charArray[1] == c || charArray[1] == Character.toUpperCase(c))
				return true;
		}

		return false;
	}

	public void translate() {
		Scanner sc = new Scanner(word);


		while (sc.hasNext()) {

			wordBuilder = new StringBuilder(sc.next());
			charArray = wordBuilder.toString().toCharArray();
			
			translateWord();

			if (sc.hasNext())
				pLatinWord += " ";
		}
	}

	public void translateWord() {

		if (firstCharIsVowel()) {
			wordBuilder.append("way");
			pLatinWord += wordBuilder.toString();
		}

		else {
			if (secondCharIsVowel()) {
				wordBuilder.append(charArray[0] + "ay");
				wordBuilder.deleteCharAt(0);
				pLatinWord += wordBuilder.toString();
			}

			else {
				wordBuilder.append(charArray[0]);
				wordBuilder.append(charArray[1] + "ay");
				wordBuilder.delete(0, 2);
				pLatinWord += wordBuilder.toString();
			}
		}

	}

	@Override
	public String toString() {
		return word + "translated into Pig Latin is: " + pLatinWord;
	}
}

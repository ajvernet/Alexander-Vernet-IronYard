package com.tiy.ssa.weekone.mathexample;

public class Maths {
	
	private Maths(){}
	
	public static int squareRoot(int x){
		
		float value = 0;
		
		for(float i = 1f, j = x; i < (j + .5); i += 1, j = j / i){
			
		
			value = i;
		}
		
		return  (int)value;
	
	}
	
	public static int cubeRoot(int x){
		int counter = 0;
		while((x / 3) != 1){
			
			x = x / 3;
			counter ++;

		}
		
		return counter;
	}
}

package com.tiy.ssa.weekone.assignmentone;

public class Power {

	private int numValue;
	
	public Power(int numValue){
		this.numValue = numValue;
	}
	
	public int powerOf(int exponent){
		if (exponent == 1) return this.numValue;
		
		else return this.numValue * powerOf(exponent - 1);
	}
	
}

package com.tiy.ssa.weekone.assignmenttwo;

public class Battery {

	final float capacity;
	
	float leftOver;
	
	public Battery(float capacity){
		this.capacity = capacity;
		this.leftOver = capacity;
	}
	
	public void discharge(float usedEnergy){
		if (leftOver - usedEnergy > 0) leftOver -= usedEnergy;
		
		else leftOver = 0;
	}
	
	public void charge(float newEnergy){
		if (leftOver + newEnergy < capacity) leftOver += newEnergy;
		
		else leftOver = capacity;
	}
}

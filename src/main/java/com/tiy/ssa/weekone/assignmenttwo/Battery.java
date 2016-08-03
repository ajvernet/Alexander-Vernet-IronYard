package com.tiy.ssa.weekone.assignmenttwo;




public class Battery {

	final float capacity;
	float leftOver;
	boolean on;
	long onTime;
	long offTime;
	final float lossRate;
	
	public Battery(float capacity){
		this(capacity, 1);
		this.leftOver = capacity;
		
	}
	
	public  Battery(float capacity, float lossRate){
		this.capacity = capacity;
		this.leftOver = capacity;
		this.lossRate = lossRate;
		
	}
	
	public void discharge(float usedEnergy){
		
		if (usedEnergy < 0) System.out.println("User error: cannot discharge a negative amount");
		
		else{
			
			if (leftOver - usedEnergy > 0) leftOver -= usedEnergy;
		
			else leftOver = 0;
		}
	}
	
	public void charge(float newEnergy){
		
		if (newEnergy < 0 ) System.out.println("User error: cannot charge a negative amount");
		
		else{
			
			if (leftOver + newEnergy < capacity) leftOver += newEnergy;
		
			else leftOver = capacity;
		}
	}
	
	public void turnOn() throws InterruptedException{
		on = true;
		onTime = System.currentTimeMillis();		
	}
	
	public void turnOff() {
		on = false;
		offTime = System.currentTimeMillis();
		discharge((offTime - onTime) / 1000 * lossRate);
	}
	
	public float getCapacity(){
		return this.capacity;
	}
	
	public float getEnergy(){
		return this.leftOver;
	}
	
	public int howLong(float power){
		return (int) (leftOver / power);
	}
}

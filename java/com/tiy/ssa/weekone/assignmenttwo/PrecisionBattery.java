package com.tiy.ssa.weekone.assignmenttwo;

import java.math.BigDecimal;

public class PrecisionBattery {

	final BigDecimal capacity;
	BigDecimal leftOver;
	boolean on;
	long onTime;
	long offTime;
	final BigDecimal lossRate;
	
	public PrecisionBattery(BigDecimal capacity){
		this(capacity, BigDecimal.ONE);
		this.leftOver = capacity;
		
	}
	
	public  PrecisionBattery(BigDecimal capacity, BigDecimal lossRate){
		this.capacity = capacity;
		this.leftOver = capacity;
		this.lossRate = lossRate;
		
	}
	
	public void discharge(BigDecimal usedEnergy){
		
		if (usedEnergy.compareTo(BigDecimal.ZERO) == -1) System.out.println("User error: cannot discharge a negative amount");
		
		else{
			
			if ((leftOver.subtract(usedEnergy)).compareTo(BigDecimal.ZERO) == 1) leftOver = leftOver.subtract(usedEnergy);
		
			else leftOver = BigDecimal.ZERO;
		}
	}
	
	public void charge(BigDecimal newEnergy){
		
		if (newEnergy.compareTo(BigDecimal.ZERO) == -1 ) System.out.println("User error: cannot charge a negative amount");
		
		else{
			
			if (leftOver.add(newEnergy).compareTo(capacity.add(BigDecimal.ONE)) == -1) leftOver = leftOver.add(newEnergy);
		
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
		discharge(lossRate.multiply(new BigDecimal((offTime - onTime) / 1000)));
	}
	
	public BigDecimal getCapacity(){
		return this.capacity;
	}
	
	public BigDecimal getEnergy(){
		return this.leftOver;
	}
	
	public int howLong(BigDecimal power){
		return (leftOver.divide(power)).intValue();
	}

}

package com.tiy.ssa.weekone.assignmentone;

public class Thermometer {
	
	int temperature;
	boolean isFahrenheit;
	
	public Thermometer(int temperature){

		this(temperature, true);
	}
	
	public Thermometer(int someTemp, boolean isFahrenheit){
		temperature = someTemp;
		this.isFahrenheit = isFahrenheit;    
	}
	
	public int display(boolean wantsFahrenheit){
		
		// thermometer temp type equal desired temp display type
		// so no conversion is needed.
		if(isFahrenheit == wantsFahrenheit)
		{
			return this.temperature;
			
		} else if (isFahrenheit == true) {
			
			// convert Celsius to Fahrenheit
			return celciusToFahrenheit(this.temperature);
			
		} else 		
			// convert Fahrenheit to Celsius
			return (fahrenheitToCelsius(this.temperature));
	}
	
	int fahrenheitToCelsius(int tempInFahrenheit){
		
		return Math.round(((tempInFahrenheit) * 9 / 5.0f + 32));
		
	}
	
	int celciusToFahrenheit(int tempInCelsius){
		
		return Math.round(((tempInCelsius - 32) * 5 / 9.0f));
	}
}

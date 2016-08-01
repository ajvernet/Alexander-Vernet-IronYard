package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThermometerTests {

	@Test
	public void displayIfEqualTypes() {
		assertEquals("", 78, new Thermometer(78, true).display(true));
		assertEquals("",  78, new Thermometer(78, false).display(false));
	}

	@Test
	public void displayCelsiusToFahrenheit() {
		assertEquals("",  32, new Thermometer(0, false).display(true));	

	}

	@Test
	public void displayFahrenheitToCelsius() {
		assertEquals("", 100, new Thermometer(212, true).display(false));
	}

	

}

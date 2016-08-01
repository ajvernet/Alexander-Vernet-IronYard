package com.tiy.ssa.weekone.assignmentone;


// testing utilizes 5 as the value for the test number.

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest {

	@Test
	public void testPowerOfOne() {
		assertEquals(5, new Power(5).powerOf(1));
	}
	
	@Test
	public void testPowerOfTwo()  {
		assertEquals(25, new Power(5).powerOf(2));
	}
	
	@Test
	public void testPowerOfThree() {
		assertEquals(125,  new Power(5).powerOf(3));
	}
	
	@Test
	public void testPowerOfFour() {
		assertEquals(625, new Power(5).powerOf(4));
	}

	private void testPowerOfFive() {
		assertEquals(3125, new Power(5).powerOf(5));

	}
}

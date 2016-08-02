package com.tiy.ssa.weekone.assignmenttwo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBattery {


	
	@Test
	public void testDischargeBatteryInRange() {
		
		Battery testBat1 = new Battery(100f);
		testBat1.discharge(50);
		assertEquals(50, testBat1.leftOver, .01);
	}

	@Test 
	public void testDischargeBatteryPastRange() {
		
		Battery testBat1 = new Battery(100f);
		testBat1.discharge(150f);
		assertTrue(testBat1.leftOver == 0.0);
	}
	
	@Test
	public void testChargeBattery(){
		
		Battery testBat1 = new Battery(100f);
		testBat1.discharge(150);	
		testBat1.charge(35);		
		assertEquals(35, testBat1.leftOver, .01);
	}
	
	@Test
	public void testChargeBatteryPastRange(){
		
		Battery testBat1 = new Battery(100f);
		testBat1.charge(150);
		
		assertEquals(100, testBat1.leftOver, 0);
		assertTrue(testBat1.leftOver == testBat1.capacity);
		
	}
}

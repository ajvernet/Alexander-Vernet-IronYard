package com.tiy.ssa.weekone.assignmenttwo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBattery {


	
	@Test
	public void testDischargeBatteryInRange() {
		
		Battery testBat1 = new Battery(100f);
		testBat1.discharge(45.6f);
		assertEquals(54.4, testBat1.leftOver, .01);
	}

	@Test 
	public void testDischargeBatteryPastRange() {
		
		Battery testBat1 = new Battery(100f);
		testBat1.discharge(150);
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
	
	@Test
	public void testTurnOnAndOff() throws InterruptedException{
		
		Battery testBat1 = new Battery(100f);
		testBat1.turnOn();
		
		assertTrue(testBat1.on == true);
		
		System.out.println(testBat1.getEnergy());
		
		Thread.sleep(3000);
		
		testBat1.turnOff();
		
		System.out.println(testBat1.getEnergy());
		assertTrue(testBat1.getEnergy() == 96f);
	}
	
	@Test
	public void testHowLong(){
		
		Battery testBat1 = new Battery(100f, 5);
		
		testBat1.discharge(10);
		
		assertTrue(testBat1.howLong() == 18f);
	}
}

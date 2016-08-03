package com.tiy.ssa.weekone.assignmenttwo;

public class TestPrecisionPrecisionBattery {
	package com.tiy.ssa.weekone.assignmenttwo;

	import static org.junit.Assert.*;

	import org.junit.Test;

	public class TestPrecisionBattery {


		
		@Test
		public void testDischargePrecisionBatteryInRange() {
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f);
			testBat1.discharge(45.6f);
			assertEquals(54.4, testBat1.leftOver, .01);
		}

		@Test 
		public void testDischargePrecisionBatteryPastRange() {
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f);
			testBat1.discharge(150);
			assertTrue(testBat1.leftOver == 0.0);
		}
		
		@Test
		public void testChargePrecisionBattery(){
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f);
			testBat1.discharge(150);	
			testBat1.charge(35);		
			assertEquals(35, testBat1.leftOver, .01);
		}
		
		@Test
		public void testNegCharge(){
			
			PrecisionBattery testBat1 = new PrecisionBattery(25f);
			testBat1.charge(-30);
			System.out.println(testBat1.leftOver);
			assertTrue(testBat1.leftOver > -1);
		}
		
		@Test
		public void testNegativePrecisionBattery(){
			
			PrecisionBattery testBat1 = new PrecisionBattery(-200);	
			assertFalse(testBat1.capacity > 0);
		}
			
		@Test
		public void testChargePrecisionBatteryPastRange(){
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f);
			testBat1.charge(150);
			
			assertEquals(100, testBat1.leftOver, 0);
			assertTrue(testBat1.leftOver == testBat1.capacity);
			
		}
		
		@Test
		public void testTurnOnAndOff() throws InterruptedException{
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f);
			testBat1.turnOn();
			
			assertTrue(testBat1.on == true);
			
			System.out.println(testBat1.getEnergy());
			
			Thread.sleep(3000);
			
			testBat1.turnOff();
			
			System.out.println(testBat1.getEnergy());
			assertTrue(testBat1.getEnergy().97f);
		}
		
		@Test
		public void testHowLong(){
			
			PrecisionBattery testBat1 = new PrecisionBattery(100f, 5);
			
			testBat1.discharge(10);
			
			assertTrue(testBat1.howLong(5) == 18);
		}
	}

}

package com.tiy.ssa.weekone.assignmentfour;

import static org.junit.Assert.*;

import org.junit.Test;

public class LazyKnightTest {

	final int maxMoves = 4;
	@Test
	public void testMoveNumber() {
		LazyKnight sirThurston = new LazyKnight(4, 2);
		
		for(int i = 0; i < maxMoves; i++){
			sirThurston.move();
			System.out.println(sirThurston.getPosition());
		}
		
		assertEquals(4, sirThurston.getXPosition(), 0);
		assertEquals(2, sirThurston.getYPosition(), 0);
	}

	@Test
	public void legalMove(){
		LazyKnight sirThurston = new LazyKnight(1, 10);
		
		sirThurston.move();
		
		assertTrue(4 > sirThurston.getXPosition() && sirThurston.getXPosition() > -2);
		assertTrue(13 > sirThurston.getYPosition() && sirThurston.getYPosition() > 7);

	}
	
	@Test
	
	public void notRetraced(){
		
		LazyKnight sirThurston = new LazyKnight(1, 10);
		sirThurston.move();
		System.out.println(sirThurston.getPosition());
		sirThurston.move();
		
		System.out.println(sirThurston.getPosition());
		assertFalse(sirThurston.getXPosition() == 1 && sirThurston.getYPosition() == 10);

	}
}

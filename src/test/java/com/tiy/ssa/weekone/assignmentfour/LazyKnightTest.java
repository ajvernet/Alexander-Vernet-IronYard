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
		}
		
		assertTrue(sirThurston.position.equals(sirThurston.home));
	}

	@Test
	public void legalMove(){
		LazyKnight sirThurston = new LazyKnight(1, 10);
		
		sirThurston.move();
		
		assertTrue(4 > sirThurston.getPosition().getX() && sirThurston.getPosition().getX() > -2);
		assertTrue(13 > sirThurston.getPosition().getY() && sirThurston.getPosition().getY() > 7);
	}
	
	@Test
	
	public void notRetraced(){
		
		Position lastPosition;
		LazyKnight sirThurston = new LazyKnight(1, 10);
		
		for(int i = 0; i < 10; i++){
			
			lastPosition = sirThurston.getPosition().clone();
			
			sirThurston.move();
			
			assertFalse(sirThurston.move().equals(lastPosition));
			System.out.println(sirThurston.toString());
			
		}
	}
}

package com.tiy.ssa.weekone.assignmentfour;

import java.util.Random;

public class LazyKnight {

	Position position, home;
	
	private int moveCount = 0;
	
	private int lastMoveX;
	private int lastMoveY;
		
	public LazyKnight(int xPosition, int yPosition){
		home = new Position(xPosition, yPosition);
		position = home;
	}
	
	public Position move(){
		
		int xMove = 0, yMove = 0;
		
		final int[] legalMoves = {-2, -1, 1, 2};
		
		switch(moveCount){
		
		case(0):
			Random r = new Random();
			xMove = legalMoves[r.nextInt(4)];
			yMove = legalMoves[r.nextInt(4)];
			break;
			
		case(1):
			xMove = -lastMoveX;
			yMove = lastMoveY;	
			break;
			
		case(2):
			xMove = lastMoveX;
			yMove = -lastMoveY;
			break;
			
		case(3):			
			xMove = -lastMoveX;
			yMove = lastMoveY;
			break;		
		}
		
		setLastMove(xMove, yMove);
		movePosition(xMove, yMove);
		moveCount++;
		
		if (position.equals(home)) moveCount = 0;
		
		return position;
	}
	
	private void movePosition(int x, int y){
		position = position.move(x, y);
	}
	
	private void setLastMove(int x, int y){
		lastMoveX = x;
		lastMoveY = y;
	}
	
	public Position getPosition(){
		return position;
	}
	
	@Override
	public String toString(){
		return position.toString(); 
	}


}

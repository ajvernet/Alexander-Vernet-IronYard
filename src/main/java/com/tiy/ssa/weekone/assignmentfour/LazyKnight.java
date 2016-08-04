package com.tiy.ssa.weekone.assignmentfour;

import java.util.Random;

public class LazyKnight {

	private int xPosition;
	private int yPosition;
	
	private int moveCount = 0;
	
	private int lastMoveX;
	private int lastMoveY;
		
	public LazyKnight(int xPosition, int yPosition){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public void move(){
		
		int xMove = 0, yMove = 0;
		
		final int[] legalMoves = {-2, -1, 1, 2};
		
		switch(moveCount){
		
		case(0):
			Random r = new Random();
			xMove = legalMoves[r.nextInt(4)];
			yMove = legalMoves[r.nextInt(4)];
			setLastMove(xMove, yMove);
			movePosition(xMove, yMove);
			break;
			
		case(1):
	
			xMove = -lastMoveX;
			yMove = lastMoveY;	
			setLastMove(xMove, yMove);
			movePosition(xMove, yMove);
			break;
			
		case(2):
			
			xMove = lastMoveX;
			yMove = -lastMoveY;
			setLastMove(xMove, yMove);
			movePosition(xMove, yMove);
			break;
			
		case(3):
			
			xMove = -lastMoveX;
			yMove = lastMoveY;
			setLastMove(xMove, yMove);
			movePosition(xMove, yMove);
			break;
		
		}



		
		moveCount++;
	}
	
	private void movePosition(int x, int y){
		xPosition += x;
		yPosition += y;
	}
	
	private void setLastMove(int x, int y){
		lastMoveX = x;
		lastMoveY = y;
	}
	
	public int getXPosition(){
		return xPosition;
	}
	
	public int getYPosition(){
		return yPosition;
	}
	public String getPosition(){
		return "x position: " + xPosition + " y position: " + yPosition;
	}


}

package com.tiy.ssa.week3.chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChessTest {

    ChessPiece piece1;
    ChessPiece piece2; 
    ChessPiece piece3;
    ChessPiece piece4;
    ChessPiece piece5;
    ChessPiece piece6;
    ChessPiece piece7;
    
    @Before
    public void setup(){
        piece1 = new ChessPiece(PieceName.QUEEN, new Location(1,4));
        piece2 = new ChessPiece(PieceName.QUEEN, new Location(3,4));
        piece3 = new ChessPiece(PieceName.KING, new Location(1,4));
        piece4 = new ChessPiece(PieceName.PAWN, new Location(4,1));
        piece5 = new ChessPiece(PieceName.BISHOP, new Location(1,4));
        piece6 = new ChessPiece(PieceName.KNIGHT, new Location(1,4));
        piece7 = new ChessPiece(PieceName.ROOK, new Location (6,6));
    }
    
    @Test
    public void testWhere(){
        
        assertEquals("",new Location(1,4), piece1.where());
    }
    
    @Test
    public void testMoveOffBoard(){
        assertFalse(piece1.canMove(new Location(-1, 2)));
    }
    
    @Test
    public void testQueenMove(){
        assertFalse(piece1.canMove(new Location(8,8)));
        assertTrue(piece1.canMove(new Location(3,6)));
    }
    
    @Test
    public void testKingMove(){
        assertFalse(piece3.canMove(new Location(3,6)));
        assertTrue(piece3.canMove(new Location(0,3)));
    }

    @Test
    public void testPawnMove(){
        assertFalse(piece4.canMove(new Location(5, 1)));
        assertTrue(piece4.canMove(new Location(4, 3)));
        assertTrue(piece4.canMove(new Location(4, 2)));
        assertFalse(piece4.canMove(new Location(4, 0)));
        assertFalse(piece4.canMove(new Location(4, 4)));
    }
    
    @Test
    public void testBishopMove(){
        assertFalse(piece5.canMove(new Location(2,4)));
        assertFalse(piece5.canMove(new Location(1, 5)));
        assertTrue(piece5.canMove(new Location(2, 5)));
    }
    
    @Test
    public void testKnightMove(){
        assertFalse(piece6.canMove(new Location(1, 6)));
        assertTrue(piece6.canMove(new Location(2, 6)));
    }
    
    @Test
    public void testRookMove(){
        assertFalse(piece7.canMove(new Location(7, 7)));
        assertTrue(piece7.canMove(new Location(6, 3)));
        assertTrue(piece7.canMove(new Location(1, 6)));
    }
    
    @Test
    public void testCompareDifferetTypes(){
        assertTrue(piece3.compareTo(piece1) >= 1);
        assertTrue(piece3.compareTo(piece4) >= 1);
        assertTrue(piece3.compareTo(piece4) >= 1);
        assertTrue(piece5.compareTo(piece4) >= 1);
        assertTrue(piece5.compareTo(piece6) == 0);
        assertTrue(piece7.compareTo(piece5) >= 1);
        assertTrue(piece1.compareTo(piece2) >= 1);
        assertTrue(piece1.compareTo(piece2) >= 1);
        assertTrue(piece1.compareTo(piece2) >= 1);       
    }
    
    @Test
    public void testCompareSameTypes(){
        assertTrue(piece1.compareTo(piece2) >= 1);
    }
    
    @Test
    public void testEquals(){
        assertEquals(piece1, piece2);
    }
    
    @Test
    public void testMoveToSameLocation(){
        assertFalse(piece1.canMove(piece1.where()));
    }
}

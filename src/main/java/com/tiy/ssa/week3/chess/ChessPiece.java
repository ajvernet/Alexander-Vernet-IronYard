package com.tiy.ssa.week3.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessPiece implements Piece{
    final PieceName name;
    Location location;
    
    public ChessPiece(PieceName name, Location location){
        this.name = name;
        this.location = location;
    }

    @Override
    public Location where() {
        return location.getLocation();
    }

    @Override
    public boolean canMove(Location where) {
        if (location.isInRange(where, 0, 7)){
        
        switch(name){
        case QUEEN:
            return (location.isHorizontal(where) || location.isVertical(where) 
                    || location.isDiagonal(where)) ? true : false;
            
        case KING:
            return ((location.isHorizontal(where) || location.isVertical(where)
                    || location.isDiagonal(where)) && location.isDistance(where, 1)) ? true: false;
            
        case BISHOP:
            return (location.isDiagonal(where)) ? true : false;
         

        case KNIGHT:
            return (location.isDistanceXY(where, 1, 2) || location.isDistanceXY(where,  2, 1)) ? true : false;
            
        case PAWN:
            if(location.getY() == 1) return (location.isVertical(where) && 
                    (location.isDistance(where, 1) || location.isDistance(where,  2))) ? true : false;
            return (location.isVertical(where) && location.isDistance(where, 1)) ? true : false;
            
        case ROOK:
            return (location.isHorizontal(where));
            
        default:
            break;    
            }
        }
        
        return false;
    }
    
    @Override
    public int getValue(){
        switch(name){
        case KING:
            return 5;
            
        case QUEEN:
            return 4;
            
        case ROOK:
            return 3;
            
        case BISHOP:
            return 2;
       
        case KNIGHT:
            return 2;
            
        case PAWN:
            return 1;
        
        default:
            break;
        
        }
        
        return 0;
    }
    
    public int distanceFromCenter(){
        
        List<Location> centerList = new ArrayList<>();
        
        centerList.add(new Location(3,3));
        centerList.add(new Location(3,4));
        centerList.add(new Location(4,3));
        centerList.add(new Location(4,4));
        
        int avg = 0;
        
        for(Location l : centerList){
            avg += location.distanceFrom(l);
        }
        return avg / 4;
        
    }
    
    @Override
    public int compareTo(Piece o) {
        
        int val1 = this.getValue();
        int val2 = o.getValue();
        
        if(val1 != val2) return val1 - val2;
        
        return this.distanceFromCenter() - ((ChessPiece)o).distanceFromCenter();

    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChessPiece other = (ChessPiece) obj;
        if (name != other.name)
            return false;
        return true;
    }
    
    
}

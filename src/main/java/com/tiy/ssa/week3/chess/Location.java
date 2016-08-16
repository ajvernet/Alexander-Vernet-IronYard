package com.tiy.ssa.week3.chess;

public class Location {
   
    public final int x;
    public final int y;
    
    
    static final int MIN = 0;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object other) {
        if (x == ((Location)other).x && y == ((Location)other).y)
            return true;

        return false;
    }

    public Location move(int x, int y) {

        return new Location(this.x + x, this.y + y);
    }
    
    public Boolean isHorizontal(Location next){
        return (Math.abs(next.y - this.y) == 0) ? true : false;
    }
    
    public Boolean isVertical(Location next){
        return (Math.abs(next.x - this.x) == 0) ? true: false;
    }
    
    public Boolean isPositiveY(Location next){
        return (next.y - this.y > 0) ? true : false;
    }
    
    public Boolean isDiagonal(Location next){
        return (Math.abs(next.x - this.x) == Math.abs(next.y - this.y));
    }

    public Boolean isDistance(Location next, int distance){
        return (Math.abs(next.x - this.x) <= distance &&
                Math.abs(next.y - this.y) <= distance) ? true: false;
    }
    
    public Boolean isDistanceXY(Location next, int distanceX, int distanceY){
        return(Math.abs(next.x - this.x) == distanceX && 
                Math.abs(next.y - this.y) == distanceY) ? true: false;
    }
    
    public Boolean isInRange(Location next, int min, int max){
        return (min <= next.x && next.x <= max && 
                next.y <= max && next.y >= min) ? true : false;
                
    }
    
    public int xDistanceFrom(Location other){
        return other.x - this.x;
    }
    
    public int yDistanceFrom(Location other){
        return other.y - this.y;
    }
    
    public int distanceFrom(Location other){
        int distance = xDistanceFrom(other) + yDistanceFrom(other);
        
        if (isDiagonal(other)) return 2 * distance;
        
        return distance;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Location getLocation(){
        return new Location(x, y);
    }
    @Override
    public String toString() {
        return "Position is: (" + x + ", " + y + ").";
    }
}

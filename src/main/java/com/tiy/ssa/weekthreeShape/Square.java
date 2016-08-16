package com.tiy.ssa.weekthreeShape;

public class Square extends Rectangle {
    

    public Square(int sideLength){
        super(sideLength, sideLength);
    }
        
    @Override
    public void setHeight(int height){
        this.height = height;
        this.width = height;
    }
    
    @Override
    public void setWidth(int height){
        this.height = height;
        this.width = height;
    }
}

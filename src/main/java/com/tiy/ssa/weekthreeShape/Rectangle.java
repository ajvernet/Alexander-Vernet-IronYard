package com.tiy.ssa.weekthreeShape;

public class Rectangle {

    int height, width;
    


    public Rectangle(int height, int width) {
        super();
        this.height = height;
        this.width = width;
    }
    
    public float area()
    {
        return getHeight() * getWidth();
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }

    public void setHeight(int height) 
    {
        this.height = height;
    }

    public void setWidth(int width) 
    {
        this.width = width;
    }
    
    
    
}

package com.tiy.ssa.weekthreeShape;

import java.util.Comparator;

public class Rectangle implements Shape{

    int height, width;
    
    public Rectangle(int height, int width) {
        super();
        this.height = height;
        this.width = width;
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
        int i = 1;
        new Comparator<Object>()
        {
            (Object o1,Object o2) -> (i + 5);
        };
        this.width = width;
    }




    @Override
    public float getArea() {
        return getHeight() * getWidth();
    }


    @Override
    public void draw() {
        // TODO Auto-generated method stub
        
    }








    
    
    
    
}

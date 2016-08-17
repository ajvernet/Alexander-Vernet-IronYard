package com.tiy.ssa.weekthreeShape;

public class Square2 implements Shape{

    final Rectangle rectangle;
    
    public Square2(int dimension){   
        rectangle = new Rectangle(dimension, dimension);
    }

    @Override
    public float getArea() {
        return rectangle.getArea();
    }

   @Override
   public void draw(){
       rectangle.draw();
   }


    


    
}

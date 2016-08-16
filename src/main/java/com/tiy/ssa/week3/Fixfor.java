package com.tiy.ssa.week3;

import java.util.Iterator;

public class Fixfor<T> implements Iterator<T>, Iterable<T> {

    final Iterator<T> decorated;

    public Fixfor(Iterator<T> decorated){
        this.decorated = decorated;
    }
    

    @Override
    public boolean hasNext() {
        return decorated.hasNext();
    }

    @Override
    public T next() {
        return decorated.next();
    }
    
    @Override
    public void remove(){
        decorated.remove();
    }


    @Override
    public Iterator<T> iterator() {
        return this;
    }


}

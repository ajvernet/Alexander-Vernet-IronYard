package com.tiy.ssa.weektwo.example1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HopTest {

    List<Hop> hops = new ArrayList<>();

    @Before
    public void setup() {
        hops.add(new Hop(5.8, "Opal", Nationality.GERMAN));
        hops.add(new Hop(12.0, "Nelson Sauvin", Nationality.NEW_ZEALAND));
        hops.add(new Hop(12.0, "Pacific Jade", Nationality.NEW_ZEALAND));
        hops.add(new Hop(4.5, "Cascade", Nationality.AMERICAN));
        hops.add(new Hop(4.0, "Centennial", Nationality.AMERICAN));
    }

    @After
    public void clear() {
        hops.clear();
    }

    @Test
    public void testAmericanList() {
        List<Hop> onlyUSHops = new ArrayList<>();

        // create new list of only American hops
        for (Hop h : hops) {
            if (h.nationality == Nationality.AMERICAN)
                onlyUSHops.add(h);
        }

        // test that new list is comprised of only American hops
        for (Hop h : onlyUSHops) {
            assertTrue(h.nationality == Nationality.AMERICAN);
        }

    }

    @Test
    public void testNoAmericanList() {
        List<Hop> noUSHops = new ArrayList<>();

        // create a new list that excludes American hops
        for (Hop h : hops) {
            if (h.nationality != Nationality.AMERICAN)
                noUSHops.add(h);
        }

        // test that new list contains no American hops
        for (Hop h : noUSHops) {
            assertTrue(h.nationality != Nationality.AMERICAN);
        }

    }

    @Test
    public void removeNonUSHops() {

        // remove non US hops from hops list
        List<Hop> noUSHops = new ArrayList<>();

        // create a new list that excludes American hops
        for (Hop h : hops) {
            if (h.nationality != Nationality.AMERICAN)
                noUSHops.add(h);
        }
        
        // remove sublist from original list
        hops.removeAll(noUSHops);
        
        // test to ensure original list contains only US hops
        for (Hop h: hops){
            assertTrue(h.nationality == Nationality.AMERICAN);
        }

    }
    public void removeUSHops() {

        // remove non US hops from hops list
        List<Hop> noUSHops = new ArrayList<>();

        // create a new list that excludes American hops
        for (Hop h : hops) {
            if (h.nationality != Nationality.AMERICAN)
                noUSHops.add(h);
        }
        
        // retain only sublist from original list
        hops.retainAll(noUSHops);
        
        // test to ensure original list contains only non US hops
        for (Hop h: hops){
            assertTrue(h.nationality != Nationality.AMERICAN);
        }

    }

}

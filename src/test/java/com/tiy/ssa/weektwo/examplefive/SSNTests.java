package com.tiy.ssa.weektwo.examplefive;

import static org.junit.Assert.*;

import org.junit.Test;

public class SSNTests {

    @Test
    public void last4(){
        assertEquals("", "6789", new SocialSecurityNumber("123456789").last4Digits());
        System.out.println(new SocialSecurityNumber("123456789").last4Digits());
    }

}

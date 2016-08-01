package com.tiy.ssa.weekone.assignmentone;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooTests {

	@Test
	public void test() {
		assertEquals(4, new Foo().helloClass());
	}
	
	@Test
	public void hiClass(){
		assertEquals(5,  new Foo().hiClass());
	}

}

package com.mphasis.training.testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDemo {
	Calculator cal;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		cal=new Calculator();
		System.out.println("before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@Test
	public void test() {
		assertEquals(56,cal.add(49,7));
		assertEquals(56,cal.add(-49,-7));
		assertNotEquals(56,cal.add(39,17));
	}
	
	@Test
	public void test1() {
		assertEquals(56,cal.sub(49,7));
		assertEquals(56,cal.sub(9,7));
		
	}
	

}

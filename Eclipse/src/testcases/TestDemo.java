package testcases;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import testing.Calculator;

public class TestDemo {
Calculator cal;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		cal=new Calculator();
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test() {
		assertEquals(56,  cal.add(49, 7));
		assertEquals(-56,  cal.add(-49, -7));
		assertNotEquals(56,  cal.add(39, 27));
	}
	@Test
	public void test1() {
		assertEquals(42,  cal.sub(49, 7));
		assertEquals(2,  cal.sub(9, 7));
	}

	@Test
	public void test2() {
		assertEquals("BC", cal.first("AABC"));
		assertEquals("JVA", cal.first("JAVA"));
		assertEquals("KVA", cal.first("KAVA"));
		assertEquals("BCD", cal.first("ABCD"));
//		assertEquals("", cal.first("A"));
		
	}
	@Test
	public void test3() {
		assertEquals(false, cal.second("ASLIS"));
		assertFalse(cal.second("ADBCE"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testArray() {
		int[] numbers=null;
		Arrays.sort(numbers);
	}
	
	@Test
	public void testArray1() {
		int[] numbers= {34,2,12,56,78};
		Arrays.sort(numbers);
		int[] expected= {2,12,34,56,78};
		assertArrayEquals(expected, numbers);
	}
	
	@Test(timeout=149)
	public void testTiming() {
		for(int i=0;i<10000000;i++) {
			int[] numbers= {i,i-1,i+1};
			Arrays.sort(numbers);
		}
	}
	
	@Test
	public void tessst() {
		
	}
	@Test
	public void tessstt() {
		assertEquals("mishra@gmail.com",cal.getEmployee("utkarsh"));
	}

}
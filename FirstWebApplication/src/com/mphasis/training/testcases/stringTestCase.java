package com.mphasis.training.testcases;
import com.mphasis.training.assignment.StringTest;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import com.mphasis.training.assignment.StringTest;


public class stringTestCase {
		StringTest helper;


	@Before
	public void setUp() throws Exception {
		helper=new StringTest();
	}

	@After
	public void tearDown() throws Exception {
		helper=null;
	}

	@Test
	public void testTruncateInFirst2Position() {
		assertEquals("BC", helper.truncateInFirst2Positions("AABC"));
		assertEquals("BCD", helper.truncateInFirst2Positions("ABCD"));
		assertEquals("BCAD", helper.truncateInFirst2Positions("BCAD"));
		assertEquals("MVA", helper.truncateInFirst2Positions("MAVA"));
		assertEquals("JVA", helper.truncateInFirst2Positions("JAVA"));
		assertEquals("KVA", helper.truncateInFirst2Positions("KAVA"));
		assertEquals("", helper.truncateInFirst2Positions("A"));
		assertEquals("" ,helper.truncateInFirst2Positions("AA"));
		
	}
	
	public void testAreFirst2charsAndLast2charsSame() {
		assertEquals(false,helper.areFirst2charsAndLast2charsSame("DFGTRDF"));
		assertFalse(helper.areFirst2charsAndLast2charsSame("ADBCE"));
		assertTrue(helper.areFirst2charsAndLast2charsSame("MAMA"));
		assertTrue(helper.areFirst2charsAndLast2charsSame("ABCDAB"));
		
	}
	
	@Test(expected=NullPointerException.class)
	 public void testArray() {
		 int[] numbers= null;
		 Arrays.sort(numbers);
	}
	
	@Test
	 public void testArray1() {
		 int[] numbers= {34,36,23,22};
		 Arrays.sort(numbers);
		 int[] expected= {2,23,32,22};
		 assertArrayEquals(expected,numbers);
	 }
	
	@Test(timeout=100)
	public void testTiming() {
		for(int i=0;i<10000000;i++) {
			int[] numbers= {i,i-1,i+1};
			Arrays.sort(numbers);
		}
	}

}

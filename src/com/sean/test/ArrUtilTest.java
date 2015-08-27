package com.sean.test;

import java.util.Arrays;
import java.util.List;

import com.sean.wang.utils.ArrUtil;

import junit.framework.TestCase;

public class ArrUtilTest extends TestCase{
	public void testMin(){
		double[] a = {1,2,3,4,5,-1,-2,-3,4,-5,2,-10,-20,100};
		assertEquals(-20.0, ArrUtil.min(a));
	}
	
	public void testToArray(){
		List<String> list = Arrays.asList(new String[]{"s","d","k"});
		String[] arr = ArrUtil.toArray(list, String.class);
		assertEquals(arr[0], "s");
		assertEquals(arr[1], "d");
		assertEquals(arr[2], "k");
	
	}
}

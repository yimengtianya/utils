package com.sean.test;

import com.sean.wang.utils.Vec3;

import junit.framework.TestCase;

public class Vec3Test extends TestCase{
	public void testCroPd(){
		double[] v1 = {1, 2, 3};
		double[] v2 = {4, 5, 6};
		double[] result = Vec3.croPd(v1, v2);
		System.out.println(result[0] + ", " + result[1] + ", " + result[2]);
	}
}

package com.sean.test;

import com.sean.wang.utils.Geom;

import junit.framework.TestCase;

public class GeomTest extends TestCase{
	public void testCounterClockwise(){
		double[][] elem = {{1,0},{2,0},{2,1},{1,1}};
		assertEquals(true, Geom.counterClockwise(elem));
		double[][] elem2 = {{2, 0},{1,0},{2,1},{1,1}};
		assertEquals(false, Geom.counterClockwise(elem2));
	}
}

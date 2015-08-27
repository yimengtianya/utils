package com.sean.test;

import java.util.Arrays;

import com.sean.wang.utils.HydroCode2D;

import junit.framework.TestCase;

public class HydroCode2DTest extends TestCase{
	
	public void testSR(){
		double[][] p = {{-1, 0},{0, 0.1},{0, 1},{-1, 1}};
		double[][] v = {{0, 0.01},{0, 0.05},{0, 0},{0, 0}};
		double[] sr = HydroCode2D.strainRate(p, v);
		System.out.println(Arrays.toString(sr));
		
		double[][] p2 = {{0, 0.1}, {1, 0}, {1, 1}, {0, 1}};
		double[][] v2 = {{0, 0.05}, {0, 0.01}, {0, 0}, {0, 0}};
		double[] sr2 = HydroCode2D.strainRate(p2, v2);
		System.out.println(Arrays.toString(sr2));
		
		double[][] p3 = {{1.0, 1.0},{0.0, 1.0},{0.0, 7.407407407407407E-14},{1.0, 7.407407407407407E-14}};
		double[][] v3 = {{0.0, 0.0},
				{0.0, 0.0},
						{0.0, 1.4814814814814815E-7},
						{0.0, 1.4814814814814815E-7}};
		double[] sr3 = HydroCode2D.strainRate(p3, v3);
		System.out.println(Arrays.toString(sr3));
	}
}

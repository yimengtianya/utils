package com.sean.test;

import com.sean.wang.utils.matrix.Matrix;
import com.sean.wang.utils.matrix.Matrix2By2;

import junit.framework.TestCase;

public class MatrixText extends TestCase{

	public void testCdot(){
		Matrix m1 = new Matrix(new double[][]{{1,2,3,4},{4,3,2,1}});
		Matrix m2 = new Matrix(new double[][]{{1,2},{3,4},{5,6},{7,8}});
		double[][] result = m1.cdot(m2).toArray();
		assertEquals(50.0, result[0][0]);
		assertEquals(60.0, result[0][1]);
		assertEquals(30.0, result[1][0]);
		assertEquals(40.0, result[1][1]);
	}
	
	public void testInv(){
		Matrix2By2 m = new Matrix2By2(new double[][]{{1, 2}, {3, 4}});
		double[][] invm = m.inv().toArray();
		assertEquals(-2.0, invm[0][0]);
		assertEquals(1.0, invm[0][1]);
		assertEquals(3/2.0, invm[1][0]);
		assertEquals(-1/2.0, invm[1][1]);
	}
}

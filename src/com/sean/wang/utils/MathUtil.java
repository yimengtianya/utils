package com.sean.wang.utils;

public class MathUtil {
	public static double max(double x, double y, double z){
		return (x >= y && x >= z)?x:max(y, z, x);
	}
	public static double absMax(double x, double y, double z){
		return max(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	public static double x_product(double[] ar1, double[] ar2){
		return ar1[0] * ar2[1] - ar1[1] * ar2[0];
	}
}

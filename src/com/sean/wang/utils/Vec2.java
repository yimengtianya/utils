package com.sean.wang.utils;

public class Vec2 {

	public static double cdot(double[] v1, double[] v2){
		return v1[0] * v2[0] + v1[1] * v2[1];
	}
	
	public static double[] xdot(double[] v1, double[] v2){
		return new double[]{v1[0] * v2[1], v1[1] * v2[0]};
	}
	public static void unitizing_(double[] v){
		double norm = norm(v);
		for(int i = 0; i < 2; i++) {
			v[i] /= norm;
		}
	}
	public static double[] unitizing(double[] v){
		double[] result = new double[v.length];
		double norm = norm(v);
		for(int i = 0; i < 2; i++){
			result[i] /= norm;
		}
		return result;
	}
	public static double norm(double[] v){
		return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
	}
	
	public static void negative_(double[] v){
		for(int i = 0; i < 2; i++) {
			v[i] = -v[i];
		}
	}
}

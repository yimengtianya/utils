package com.sean.wang.utils;

import static com.sean.wang.utils.ArgumentCheck.*;

public class Vec3 {
	
	/**
	 * calculate the dot product of {@code v1} and {@code v2}.
	 * @param v1 a three dimension vector of {@code double} values. 
	 * @param v2 another three dimesion vector of {@code double} values.
	 * @return the dot product of {@code v1} and {@code v2}
	 * @throws IllegalArgumentException if {@code v1} or {@code v2} is not a three dimensional vector
	 */
	public static double dotPd(double[] v1, double[] v2){
		checkArgument(v1.length == 3 && v2.length == 3, "the length of the args should be 3");
		return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
	}
	
	/**
	 * calculate the cross product of {@code v1} and {@code v2}.
	 * @param v1 a three dimension vector of {@code double} values. 
	 * @param v2 another three dimesion vector of {@code double} values.
	 * @return the cross product of {@code v1} and {@code v2}
	 * @throws IllegalArgumentException if {@code v1} or {@code v2} is not a three dimensional vector
	 */
	public static double[] croPd(double[] v1, double[] v2){
		checkArgument(v1.length == 3 && v2.length == 3, "the length of the args should be 3");
		double[] result = new double[3];
		result[0] = v1[1] * v2[2] - v1[2] * v2[1];
		result[1] = - (v1[0] * v2[2] - v1[2] * v2[0]);
		result[2] = v1[0] * v2[1] - v1[1] * v2[0];
		return result;
	}
	
	public static double[] minus(double[] v1, double[] v2){
		return new double[]{v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]};
	}
	
	public static void negative_(double[] v){
		for(int i = 0; i < v.length; i++) {
			v[i] = -v[i];
		}
	}
	
	public static void unitizing_(double[] v, int index) {
		double val = v[index];
		for(int i = 0; i < 3; i++) {
			v[i] /= val;
		}
	}
	public static double[] unitizing(double[] v, int index){
		double[] result = new double[v.length];
		for(int i = 0; i < 3; i++) {
			result[i] = v[i] / v[index];
		}
		return result;
	}
	
	public static void unitizing_(double[] v){
		double norm = norm(v);
		for(int i = 0; i < 3; i++) {
			v[i] /= norm;
		}
	}
	
	
	public static double norm(double[] v){
		return Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
	}
	
	public static double[] delete(double[] v, int index){
		if(index > v.length) {
			return v;
		}
		double[] result = new double[2];
		for(int i = 0; i < 3; i++) {
			if(index == i) {
				continue;
			}
			result[i] = v[i];
		}
		return result;
	}
}

package com.sean.wang.utils;

public class Array {
	public static double sum(double[] arr){
		double sum = 0;
		for(int i = 0, len = arr.length; i < len; i++){
			sum += arr[i];
		}
		return sum;
	}
}

package com.sean.wang.utils;

import java.util.ArrayList;
import java.util.List;

public class LsUtil<T> {
	
	public static double sum(List<Double> list){
		double sum = 0;
		for(Double e:list)
			sum += e;
		return sum;
	}
	
	public static <T> boolean contains(List<T> list, T[] sub){
		for(T t:sub){
			if(!list.contains(t)){
				return false;
			}
		}
		return true;
	}
	
	public static <T> T except(List<T> ls1, List<T> ls2){
		for(int i = 0; i < ls1.size(); i++){
			boolean contain = false;
			for(int j = 0; j < ls2.size(); j++){
				if(ls1.get(i) == ls2.get(j)){
					contain = true;
				}
			}
			if(!contain)
				return ls1.get(i);
		}
		return null;
	}
	
	public static <T> int[] latestIndex(List<T> list, int n){
		int[] result = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = list.size() - (n - i);
		}
		return result;
	}
	
	public static List<Double> extract(List<double[]> list, int n){
		List<Double> result = new ArrayList<>();
		for(int i = 0, len = list.size(); i < len; i++){
			if(list.get(i) == null || list.get(i).length <= n)
				continue;
			result.add(list.get(i)[n]);
		}
		return result;
	}
	
	public static double[][] toArray(List<double[]> list){
		double[][] result = new double[list.size()][];
		for(int i = 0, len = list.size(); i < len; i++){
			double[] li = list.get(i);
			double[] ar = new double[li.length];
			for(int j = 0; j < ar.length; j++){
				ar[j] = li[j];
			}
			result[i] = ar;
		}
		return result;
	}
	public static int[] toIntArray(List<Integer> list){
		int[] result=  new int[list.size()];
		for(int i = 0, len = result.length; i < len; i++){
			result[i] = list.get(i);
		}
		return result;
	}
}

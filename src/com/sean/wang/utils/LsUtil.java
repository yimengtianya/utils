package com.sean.wang.utils;

import java.util.List;

public class LsUtil<T> {
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
}

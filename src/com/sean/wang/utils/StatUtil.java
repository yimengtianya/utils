package com.sean.wang.utils;

import java.util.List;

public class StatUtil {
	public static double var(List<Double> list){
		if(list == null || list.size() <= 1)
			return 0;
		double mean = LsUtil.sum(list) / (double)list.size();
		return list.stream().mapToDouble(e -> Math.pow(e - mean, 2)).sum() / (double)(list.size() - 1);
	}
	
	public static double sd(List<Double> list){
		return Math.sqrt(var(list));
	}
}

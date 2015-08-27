package com.sean.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sean.wang.utils.LsUtil;
import com.sean.wang.utils.StatUtil;

import junit.framework.TestCase;

public class StatUtilTest extends TestCase{
	public void testVar(){
		List<Double> list = Arrays.asList(0.0, 5.0, -8.0, 7.0, -3.0);
		double s = StatUtil.var(list);
		System.out.println(s);
		
		double sd = StatUtil.sd(list);
		System.out.println(sd);
	}
	
	public void testRange(){
		List<Double> list = new ArrayList<>();
		for(int i = 0; i < 200; i++)
			list.add(Math.random() * 100);
		
		
		double mean = LsUtil.sum(list) / (double)list.size();
		System.out.println("mean = " + mean);
		double sd = StatUtil.sd(list);
		System.out.println("sd  = " + sd);
		
	    long count = list.stream().filter(e -> e > mean - sd && e < mean + sd).count();
	    System.out.println(count);
	}
}

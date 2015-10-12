package com.sean.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sean.wang.utils.FileIO;
import com.sean.wang.utils.LsUtil;

import junit.framework.TestCase;

public class LsUtilTest extends TestCase{
	
	public void testMerge(){
		List<Double> list  = Arrays.asList(1.0,2.0,3.0);
		List<double[]> l = Arrays.asList(new double[]{1,2}, new double[]{2,3}, new double[]{4,5});
		List<double[]> result = LsUtil.merge(list, l);
		result.forEach(e -> System.out.println(Arrays.toString(e)));
	}
	
	public void testFlat() {
		List<double[]> list = Arrays.asList(new double[]{1, 2}, new double[]{2, 3}, new double[]{3, 4});
		double[] result = LsUtil.flat(list);
		for(double r:result) {
			System.out.println(r);
		}
	}
	
	public void testToArr(){
		int n = 10;
		List<Double> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(Math.random() * 10000);
		}
		
		long s = System.nanoTime();
//		LsUtil.toDoubleArray(list);
		
		Double[] k = (Double[]) list.toArray(new Double[0]);
		long e = System.nanoTime();
		System.out.println(e - s);
	}
	
	public void testBinarySearch() {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1,2,3,4,5));
		int index = LsUtil.binarySearch(list, 1);
		assertEquals(index, 0);
		assertEquals(LsUtil.binarySearch(list, 2), 1);
		assertEquals(LsUtil.binarySearch(list, 3), 2);
		assertEquals(LsUtil.binarySearch(list, 4), 3);
		assertEquals(LsUtil.binarySearch(list, 5), 4);
	}
	
	public void testWithin(){
		List<double[]> list=  new ArrayList<>();
		List<Double> xd=  new ArrayList<>();
		List<Double> yd=  new ArrayList<>();
		xd.add(0.5);
		yd.add(0.3);
		yd.add(0.7);
		list.addAll(Arrays.asList(new double[]{0,0}, new double[]{1,1}, new double[]{0.5,0.5}));
		List<Integer> result = LsUtil.within(list, xd, yd);
		System.out.println(result);
	}
	
	public void testSelectClosest() {
		try {
			List<double[]> list = FileIO.readDoubleArrList("E:/data/cenac.txt", "\\s+");
			List<double[]> list2 = FileIO.readDoubleArrList("E:/data/mn.txt", "\\s+");
			List<double[]> result = LsUtil.selectClosest(list, LsUtil.extract(list2, 0));
			System.out.println(LsUtil.toString(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testFind(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		assertEquals(3, LsUtil.findNext(list, 2));
		assertEquals(7, LsUtil.findPre(list, 1));
		assertEquals(1, LsUtil.findNext(list, 7));
	}
}

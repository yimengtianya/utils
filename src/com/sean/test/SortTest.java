package com.sean.test;

import java.util.ArrayList;
import java.util.List;

import com.sean.wang.utils.Sort;

import junit.framework.TestCase;

public class SortTest extends TestCase{
	private int n = 100;
	private List<Double> list = new ArrayList<>();
	private double[] arr = new double[n];
	
	
	public void setUp(){
		for(int i = 0; i < n; i++) {
			list.add(Math.random() * 1000);
			arr[i] = Math.random() * 1000;
		}
	}
	
	public void testMergeSort(){
		Sort.mergeSort(arr);
		for(double d:arr){
			System.out.println(d);
		}
	}
	
	public void testMergeSort2(){
		Sort.mergeSort(list);
		list.forEach(e -> System.out.println(e));
	}
	
	public void testInsertionSortIt(){
		Sort.insertion_sort_it(list);
		list.forEach(e -> System.out.println(e));
	}
	
	public void testInsertionSort(){
		Sort.insertionSort(list, false);
		list.forEach(e ->System.out.println(e));
	}
	
}

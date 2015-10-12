package com.sean.test;

import com.sean.wang.utils.ListFlu;

public class ListFluTest {
	public static void main(String[] args){
		ListFlu<Double> list = new ListFlu<>();
		list.add(10.0)
			.add(20.0)
			.add(30.0);
		System.out.println(list.toString());
	}
}

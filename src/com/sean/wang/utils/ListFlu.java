package com.sean.wang.utils;

import java.util.ArrayList;
import java.util.List;

public class ListFlu<T> {
	private List<T> list = new ArrayList<>();
	
	public ListFlu<T> add(T t){
		list.add(t);
		return this;
	}
	public String toString(){
		String string= "";
		for(T t: list){
			string += t.toString() + " ";
		}
		return string;
	}
}

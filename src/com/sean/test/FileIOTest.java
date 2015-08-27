package com.sean.test;

import java.util.List;

import com.sean.wang.utils.FileIO;

import junit.framework.TestCase;

public class FileIOTest extends TestCase{

	public void test(){
		List<double[]> vertices = FileIO.readDoubleArrList("E:/test10/vertices.txt", ",");
		List<int[]> edges = FileIO.readIntArrList("E:/test10/edges.txt");
		List<int[]> elements = FileIO.readIntArrList("E:/test10/elements.txt");
		
		vertices.remove(103040);
		
	}
	
}

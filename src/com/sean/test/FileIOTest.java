package com.sean.test;

import java.io.IOException;
import java.util.List;

import com.sean.wang.utils.FileIO;

import junit.framework.TestCase;

public class FileIOTest extends TestCase{

	public void test(){
		List<double[]> vertices = null;
		try {
			vertices = FileIO.readDoubleArrList("E:/test10/vertices.txt", ",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<int[]> edges = FileIO.readIntArrList("E:/test10/edges.txt");
		List<int[]> elements = FileIO.readIntArrList("E:/test10/elements.txt");
		
		vertices.remove(103040);
		
	}
	
}

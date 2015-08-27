package com.sean.wang.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sean.wang.utils.ArrUtil;
import com.sean.wang.utils.FileIO;
import com.sean.wang.utils.Geom;
import com.sean.wang.utils.Sort;

public class App {
	public static void main(String[] args) throws IOException{
//		
//		List<int[]> edges = new ArrayList<>();
//		long start = System.nanoTime();
//		FileReader edges_file = new FileReader("E:\\data5\\edges.txt");
//		BufferedReader reader = new BufferedReader(edges_file);
//		String str = null;
//		while((str = reader.readLine()) != null){
//			String[] ss = str.split(",");
//			int n1 = Integer.valueOf(ss[0]);
//			int n2 = Integer.valueOf(ss[1]);
//			edges.add(new int[]{n1, n2});
//		}
//		reader.close();
//		long end = System.nanoTime();
//		System.out.println(end - start);
//		
//		int[] arr = new int[edges.size() * 2];
//
//		for(int i = 0, len = edges.size(); i < len; i++){
//			arr[2 * i] = edges.get(i)[0];
//			arr[2 * i + 1] = edges.get(i)[1];
//		}
//		FileIO.writeIntArr(arr, "E:\\data1\\lines.txt");
		
//		List<int[]> list = new ArrayList<>();
//		int[] a = FileIO.readIntArr("E:\\data2\\edges.txt");
//		for(int i = 0, len = a.length / 2; i < len; i++){
//			list.add(new int[]{a[2 * i], a[2 * i + 1]});
//			System.out.println(a[2 * i] + ", " + a[2 * i + 1]);
//		}
//		System.out.println(a.length);
//
//		double[] ad = FileIO.readDoubleArr("E:\\data2\\vertices.txt");
//		for(int i = 0, len = a.length / 2; i < len; i++){
//			System.out.println(ad[2 * i] + ", " + ad[2 * i + 1]);
//		}
//		System.out.println(ad.length / 2);
		
//		int[] a = new int[10];
//		for(int i = 0, len = a.length; i< len ; i++){
//			a[i] = i;
//		}
//		int[] c = Array.add(a, new int[]{1,2,3});
//		System.out.println(Arrays.toString(c));
//		
//		int[] a = {1,2,3,4,5,6,7,8,9};
//		System.out.println(Arrays.toString(ArrUtil.toArray1(ArrUtil.toArrayN(a, 2))));
		
//		ArrayList<Integer> a = new ArrayList<>();
//		a.add(1);
//		a.add(1);
//		a.add(1);
//		System.out.println(a.toString());
		
//		int[] a = {1,2, 100, 10, 12, 20, 11};
//		int[] b = {1, 2, 13};
//		System.out.println(ArrUtil.contains(a, b));
//		
//		double[][] tri = {{56.13100437677234, 9.513934356325649}, 
//				{-374.4611159528931, -374.4611159528931}, 
//				{22.452138349733197, 40.13392522995461}};
//		double[] p = {24.345740061546795, 56.924530371971436};
//		double[][] tri = {{-1898.89, 632.97},{-1828.80398, 426.20629},{-1509.89497, 531.34112}};
//		double[] p = {-1769.23, 250.98};
//		System.out.println(Geom.Triangle.inCircumCircle(tri, p));
		
		
		
//		long start = System.nanoTime();
//		for(int i = 0;i <1000; i++){
//			double[] p = {Math.random() * 100, Math.random() * 100};
//			double[][] tri = {{-50 + Math.random() * 100, 150 + Math.random() * 100}, 
//					{-50 + Math.random() * 100, 150 + Math.random() * 100}, 
//					{-50 + Math.random() * 100, 150 + Math.random() * 100}};
//			Geom.Triangle.circumCenterOf(tri);
//		}
//		long end = System.nanoTime();
//		System.out.println(end - start);
		
//		int n = 1000;
//	
//		double[][] ps = new double[n][];
//		double[][][] tris = new double[n][][];
//		for(int i = 0;i <1000; i++){
//			double[] p = {Math.random() * 100, Math.random() * 100};
//			double[][] tri = {{-50 + Math.random() * 100, 150 + Math.random() * 100}, 
//					{-50 + Math.random() * 100, 150 + Math.random() * 100}, 
//					{-50 + Math.random() * 100, 150 + Math.random() * 100}};
//			ps[i] = p;
//			tris[i] = tri;
//			
//		}
//		long start = System.nanoTime();
//		for(int i =0; i < n; i++){
//			Geom.Triangle.inCircumCircle(tris[i], ps[i]);
//			//Geom.Triangle.inCircumCenterOf(tris[i], ps[i]);
//		}
//		long end = System.nanoTime();
//		System.out.println(end - start);
		
//		List<double[]> vertices = ArrUtil.toListdn(FileIO.readDoubleArr("E:\\data10\\vertices.dat"), 2);
//		vertices.forEach(e -> System.out.println(e[0] + ", " + e[1]));
//		
//		List<int[]> triangles = ArrUtil.toListin(FileIO.readIntArr("E:\\data10\\elements.dat"), 3);
//		triangles.forEach(e -> System.out.println(e[0] + ", " + e[1] + ", " + e[2]));
//		
//		List<List<Integer>> list = FileIO.readIntListList("E:\\data10\\neigbors.txt");
//		list.forEach(e -> {
//			System.out.println(e);
//		});
//		
//		double temp = arr[i];
//		if(temp > arr[i - 1])
//			continue;
//		int count = 0;
//		for(int j = i - 1; j >= 0; j--){
//			if(arr[j] > temp)
//				count++;
//		}
//		int index = i;
//		for(int k = 0; k < count; k++){
//			arr[index] = arr[index - 1];
//			index--;
//		}
//		arr[index] = temp;
		
//		int n = 100000;
//		double[] p = new double[n];
//		double[] p2 = new double[n];
//		for(int i = 0; i < n; i++){
//			p[i] = Math.random() * 100000;
//			p2[i] = Math.random() * 100000;
//		//	System.out.println(p[i] + ", " + p2[i]);
//		}
		//p =new double[] {1,4,6,8,9,2,3, 5, 7, 10};
//		Sort.insertionSort(p, true);
//		Sort.insertionSort(p2, true);
		//double[] arr = ArrUtil.merge(p, p2);
//		for(int i = 0; i < arr.length; i++){
//			System.out.println(arr[i]);
//		}
//		System.out.println(arr.length);
//		Sort.merge(arr, 0, p.length - 1, arr.length - 1);
		//Sort.mergeSort(p);
		//long s = System.currentTimeMillis();
		//Sort.insertionSort(p, true);
		//Sort.quickSort(p);
//		Sort.mergeSort(p);
//		long e = System.currentTimeMillis();
//		System.out.println(e - s);
		
		//s = System.nanoTime();
		//Sort.insertionSort(p);
		//Sort.quickSort(p2);
		//e = System.nanoTime();
		//System.out.println(e - s);
//		for(int i = 0; i < p.length; i++){
//			System.out.println(p[i]);
//		}
//		
//		System.out.println(ArrUtil.binarySearch(p, 8));
//		System.out.println(Arrays.toString(ArrUtil.binarySearchEx(p, -1)));
//		
//		
//		double[][] a = {{1,1},{2,2},{3,3}};
//		double[][] b = new double[a.length][];
//		System.arraycopy(a, 0, b, 0, a.length);
//		a[1][1]+=1;
//		for(double[] d:b){
//			System.out.println(d[0] + "," + d[1]) ;
//		}
		
//		List<Double> list = new ArrayList<>();
//		list.add(1.0);
//		list.add(2.0);
//		FileIO.writeDoubleList(list, "E:\\list.txt");
//		
//		int n = 1000000;
//		int row = 1000;
//		double[] arr1 = new double[n];
//		double[][] arr2 = new double[n / row][n / row];
//		List<Double> list = new ArrayList<>();
//		for(int i = 0; i < n; i++){
//			double a = Math.random();
//			arr1[i] = a;
//			list.add(a);
//			arr2[i / row][i % row] = a;
//		}
//		
//		 long s = System.nanoTime();
//		 for(int i = 0; i < n; i++){
//			 arr1[i] *= Math.pow(Math.E, Math.PI);
//		 }
		 
//		 for(int i = 0; i < row; i++){
//			 for(int j = 0; j < row; j++){
//				 arr2[i][j] *= Math.pow(Math.E, Math.PI);
//			 }
//		 }
//		 
//		 for(int i = 0; i < n; i++){
//			 list.set(i, list.get(i) * Math.pow(Math.E, Math.PI));
//		 }
//		 long e = System.nanoTime();
//		 System.out.println(e - s);
	
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(1);
		s.add(1);
		s.add(1);
	
	}
}

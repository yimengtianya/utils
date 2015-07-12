package com.sean.wang.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sean.wang.utils.ArrUtil;

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
		
		int[] a = {1,2, 100, 10, 12, 20, 11};
		int[] b = {1, 2, 13};
		System.out.println(ArrUtil.contains(a, b));
	}
}

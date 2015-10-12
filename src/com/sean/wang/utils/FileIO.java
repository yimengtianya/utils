package com.sean.wang.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileIO {
	
	public static BufferedReader getBufferedReader(String file) throws FileNotFoundException{
		return new BufferedReader(new FileReader(file));
	}
	
	public static int[] readIntArr(String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		IntBuffer ib = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).asIntBuffer();
		int[] result = new int[(int) (channel.size() / 4)];
		int index = 0;
		while(ib.hasRemaining()){
			result[index++] = ib.get();
		}
		channel.close();
		return result;
		
	}
	
	public static void writeIntArr(int[] arr, String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		IntBuffer ib = channel.map(FileChannel.MapMode.READ_WRITE, 0, arr.length * 4).asIntBuffer();
		System.out.println(arr.length * 4);
		for(int i = 0, len = arr.length; i < len; i++){
			ib.put(arr[i]);
		}
		channel.close();
	}
	
	public static void writeIntArrList(List<int[]> list, String path) throws IOException{
		FileWriter writer = new FileWriter(new File(path));
		for(int i = 0, len = list.size(); i < len; i++){
			int[] ar = list.get(i);
			for(int j = 0; j < ar.length - 1; j++){
				writer.write(ar[j] + ",");
			}
			writer.write(ar[ar.length - 1] + "\r\n");
		}
		writer.close();
	}
	
	public static void writeIntArrList(List<int[]> list, String path, String separator) throws IOException {
		FileWriter writer = new FileWriter(path);
		for(int[] arr : list) {
			StringBuilder builder = new StringBuilder();
			for(int a: arr) {
				builder.append(a + separator);
			}
			writer.write(builder.toString() + "\r\n");
		}
		writer.close();
	} 
	
	public static <T> void writerArrList(List<T[]> list, String path, String separator) throws IOException{
		FileWriter writer = new FileWriter(path);
		for(T[] arr: list) {
			StringBuilder builder = new StringBuilder();
			for(T t: arr) {
				builder.append(t + separator);
			}
			writer.write(builder.toString() + "\r\n");
		}
		writer.close();
	}
	
	public static void writeDoubleArr(double[][] arr, String path){
		File file = new File(path);
		try{
			if(arr != null){
				FileWriter writer = new FileWriter(file);
				for(double[] ar:arr){
					for(double a:ar){
						writer.write(a + ", ");
					}
					writer.write("\r\n");
				}
				writer.close();
			}
		}catch(IOException e){
			System.out.println("Error: save mesh error");
		}
	}
	public static void writeIntListList(List<List<Integer>> list, String path){
		try{
			FileWriter writer = new FileWriter(new File(path));
			for(int j = 0, len = list.size(); j < len; j++){
				List<Integer> li = list.get(j);
				if(li.size() == 0)
					continue;
				for(int i = 0; i < li.size() - 1; i++){
					writer.write(li.get(i) + ",");
				}
				writer.write(li.get(li.size() - 1) + "\r\n");
			}
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void writeIntListList(List<List<Integer>> list, String path, String separator){
		try{
			FileWriter writer = new FileWriter(new File(path));
			for(int j = 0, len = list.size(); j < len; j++){
				List<Integer> li = list.get(j);
				if(li.size() == 0)
					continue;
				for(int i = 0; i < li.size() - 1; i++){
					writer.write(li.get(i) + separator);
				}
				writer.write(li.get(li.size() - 1) + "\r\n");
			}
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static <T> void writeListList(List<List<T>> list, String path, String separator) throws IOException{
		FileWriter writer = new FileWriter(new File(path));
		for(int j = 0, len = list.size(); j < len; j++){
			List<T> li = list.get(j);
			if(li.size() == 0)
				continue;
			for(int i = 0; i < li.size() - 1; i++){
				writer.write(li.get(i).toString() + separator);
			}
			writer.write(li.get(li.size() - 1) + "\r\n");
		}
		writer.close();
	}

	
	public static List<List<Integer>> readIntListList(String path){
		List<List<Integer>> list = new ArrayList<>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String str = null;
			
			while((str = reader.readLine()) != null){
				String[] ss = str.split(",");
				List<Integer> li = new ArrayList<>();
				for(String s:ss){
					li.add(Integer.parseInt(s));
				}
				
				list.add(li);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return list;
	}
	public static List<int[]> readIntArrList(String path){
		List<int[]> result = new ArrayList<>();
		try{
			FileReader file = new FileReader(path);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(file);
			String str = null;
			while((str = reader.readLine()) != null){
				String[] ss = str.split(",");
				int[] ar = new int[ss.length];
				for(int i = 0; i < ss.length; i++){
					ar[i] = Integer.parseInt(ss[i]);
				}
				result.add(ar);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return result;
	}
	public static List<int[]> readIntArrList(String path, String separator) throws IOException{
		List<int[]> result = new ArrayList<>();
			FileReader file = new FileReader(path);
			BufferedReader reader = new BufferedReader(file);
			String str = null;
			while((str = reader.readLine()) != null){
				String[] ss = str.split(separator);
				int[] ar = new int[ss.length];
				for(int i = 0; i < ss.length; i++){
					ar[i] = Integer.parseInt(ss[i]);
				}
				result.add(ar);
			}
			reader.close();
		return result;
	}
	public static void readIntArrList(List<int[]> list, String path, String separator) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String str = null;
		while((str = reader.readLine()) != null){
			String[] ss = str.split(separator);
			int[] ar = new int[ss.length];
			for(int i = 0; i < ss.length; i++){
				ar[i] = Integer.parseInt(ss[i]);
			}
			list.add(ar);
		}
		reader.close();
	}
	
	
	public static double[] readDoubleArr(String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		DoubleBuffer db = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).asDoubleBuffer();
		double[] result = new double[(int) (channel.size() / 8)];
		int index = 0;
		while(db.hasRemaining()){
			result[index++] = db.get();
		}
		channel.close();
		return result;
	}
	
	
	public static String[] readByLines(String path) throws IOException{
		return ArrUtil.toArray(readListByLines(path), String.class);
	}
	public static List<String> readListByLines(String path) throws IOException{
		List<String> str = new ArrayList<>();
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String s = null;
		while ((s = reader.readLine()) != null) {
			str.add(s);
		}
		return str;
	}
	
	public static String readString(String path) throws IOException{
		StringBuilder result = new StringBuilder();
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String s = null;
		while((s = reader.readLine()) != null){
			result.append(s);
		}
		return result.toString();
	}
	
	public static List<double[]> readDoubleArrList(String path, String sep) throws IOException{
		List<double[]> result = new ArrayList<>();
		FileReader file = new FileReader(path);
		BufferedReader reader = new BufferedReader(file);
		String str = null;
		while ((str = reader.readLine()) != null) {
			String[] ss = str.split(sep);
			double[] ar = new double[ss.length];
			for (int i = 0; i < ss.length; i++) {
				ar[i] = Double.parseDouble(ss[i]);
			}
			result.add(ar);
		}
		reader.close();
		return result;
	}
	public static void readDoubleArrList(List<double[]> list, String path, String sep) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String str = null;
		while ((str = reader.readLine()) != null) {
			String[] ss = str.split(sep);
			double[] ar = new double[ss.length];
			for (int i = 0; i < ss.length; i++) {
				ar[i] = Double.parseDouble(ss[i]);
			}
			list.add(ar);
		}
		reader.close();
	}
	
	public static void writeDoubleArr(double[] arr, String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		DoubleBuffer db = channel.map(FileChannel.MapMode.READ_WRITE, 0, arr.length * 8).asDoubleBuffer();
		for(int i = 0, len = arr.length; i < len; i++){
			db.put(arr[i]);
		}
		channel.close();
	}
	
	public static void writeDoubleArr_stream(double[] arr, String path)  throws IOException{
		FileWriter writer = new FileWriter(new File(path));
		for(int i = 0, len = arr.length; i < len; i++){
			writer.write(arr[i] + "\r\n");
		}
		writer.close();
	}
	
	public static void writeDoubleList(List<Double> list, String path) throws IOException {
		FileWriter writer = new FileWriter(new File(path));
		for (int j = 0, len = list.size(); j < len; j++) {
			writer.write(list.get(j) + "\r\n");
		}
		writer.close();
	}

	public static void writeDoubleArrList(List<double[]> list, String path) throws IOException{
		File file = new File(path);
		FileWriter writer = new FileWriter(file);
		for(int i = 0, len = list.size(); i < len; i++){
			double[] ar = list.get(i);
			for(int j = 0; j < ar.length - 1; j++){
				writer.write(ar[j] + "\t");
			}
			writer.write(ar[ar.length - 1] + "\r\n");
		}
		writer.close();
	}
	
	public static void writeDoubleArrList(List<double[]> list, String path, String separator) throws IOException {
		FileWriter writer = new FileWriter(path);
		for(double[] arr : list) {
			StringBuilder builder = new StringBuilder();
			for(double a : arr) {
				builder.append(a + separator);
			}
			writer.write(builder.toString() + "\r\n");
		}
		writer.close();
	}
	
	public static void writeHashMapID(HashMap<Integer, Double> map, String path) throws IOException{
		FileWriter writer = new FileWriter(new File(path));
		map.entrySet().forEach(e ->{
			try {
				writer.write(e.getKey() + "\t" + e.getValue() + "\r\n");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		writer.close();
	}

}

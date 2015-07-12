package com.sean.wang.utils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class FileIO {
	public static int[] readIntArr(String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		IntBuffer ib = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()).asIntBuffer();
		System.out.println(channel.size());
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
	
	public static void writeDoubleArr(double[] arr, String path) throws IOException{
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(path, "rw").getChannel();
		DoubleBuffer db = channel.map(FileChannel.MapMode.READ_WRITE, 0, arr.length * 8).asDoubleBuffer();
		for(int i = 0, len = arr.length; i < len; i++){
			db.put(arr[i]);
		}
		channel.close();
	}
	
	
}

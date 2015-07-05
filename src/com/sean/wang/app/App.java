package com.sean.wang.app;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class App {
	public static void main(String[] args){
		//System.out.println(Geom.area(new double[][]{{0, 0}, {1, 1}, {1, 0}, {0, 0.5}}));
		try {
			RandomAccessFile afile = new RandomAccessFile("E:\\nsx.txt", "rw");
			
			FileChannel inChannel = afile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while(bytesRead != -1){
				System.out.println(bytesRead);
				buf.flip();
				while(buf.hasRemaining()){
					//System.out.println((char)buf.get());
				}
				System.out.println(buf);
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			
			afile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

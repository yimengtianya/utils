package com.sean.wang.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOUtil {
	
	public static IOUtil util(){
		return new IOUtil();
	}

	public BufferedReaderUtil bufferedReader(String file) throws FileNotFoundException {
		return new BufferedReaderUtil(file);
	}
	
	public class BufferedReaderUtil{
		
		private BufferedReader bufferedReader;
		
		public BufferedReaderUtil(String file) throws FileNotFoundException{
			bufferedReader = new BufferedReader(new FileReader(file));
		}
		public BufferedReaderUtil locateAt(String location) throws IOException{
			String line = bufferedReader.readLine();
			while(!line.contains(location)){
				line = bufferedReader.readLine();
			}
			return this;
		}
		
		public BufferedReaderUtil forward(int numLines) throws IOException {
			for(int i = 0; i < numLines; i++) {
				bufferedReader.readLine();
			}
			return this;
		}
		
		public BufferedReader get(){
			return bufferedReader;
		}
		
	}
	
	
}

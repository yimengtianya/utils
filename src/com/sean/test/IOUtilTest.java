package com.sean.test;

import java.io.BufferedReader;
import java.io.IOException;

import com.sean.wang.utils.IOUtil;

import junit.framework.TestCase;

public class IOUtilTest extends TestCase{

	public void testBufferedReader() {
		try {
			BufferedReader reader = IOUtil.util()
											  .bufferedReader("E:/data/prj.exp")
											  .locateAt("*NODE")
											  .forward(1)
											  .get();
			System.out.println(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

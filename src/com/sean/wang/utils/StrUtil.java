package com.sean.wang.utils;

public class StrUtil {
	 public static String upperCase(String str, int index){
		 if (index < 0 || index >= str.length())
			 return str;
		 char[] c = str.toCharArray();
		 c[index] = Character.toUpperCase(c[index]);
		 return String.valueOf(c);
	 }
}

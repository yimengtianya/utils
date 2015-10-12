package com.sean.wang.utils;

public class ArgumentCheck {
	public static void checkArgument(boolean isLegal){
		if(!isLegal) {
			throw new IllegalArgumentException();
		}
	}
	
	public static void checkArgument(boolean isLegal, String errroMessage){
		if(!isLegal) {
			throw new IllegalArgumentException(errroMessage);
		} 
	}
}

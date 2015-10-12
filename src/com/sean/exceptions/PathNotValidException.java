package com.sean.exceptions;

public class PathNotValidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PathNotValidException(){
		super();
	}
	public PathNotValidException(String name){
		super(name);
	}
	
}

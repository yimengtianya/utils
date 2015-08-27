package com.sean.xmlutil;

public class A {
	
	B b;
	
	public A(B b){
		this.b = b;
	}
	
	public void run(){
		System.out.println("A run");
		b.run();
	}
	
}

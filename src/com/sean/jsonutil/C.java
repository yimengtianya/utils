package com.sean.jsonutil;

public class C extends B{
	
	private int age;



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "C [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

	public void run(){
		System.out.println("C run");
	}
	
}

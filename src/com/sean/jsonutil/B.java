package com.sean.jsonutil;

public class B {
	protected int id;
	protected String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "B [id=" + id + ", name=" + name + "]";
	}
	
	public void run(){
		System.out.println("B run");
	}
	
}

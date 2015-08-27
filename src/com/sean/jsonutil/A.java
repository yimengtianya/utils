package com.sean.jsonutil;

public class A {
	
	public final static String C = "c";
	public final static String D = "d";
	
	private String name;
	private String gender;
	private int age;
	private B weapon;
	
	public void run(){
		System.out.println("A run");
		weapon.run();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public B getWeapon() {
		return weapon;
	}
	public void setWeapon(B weapon) {
		this.weapon = weapon;
	}
	@Override
	public String toString() {
		return "A [name=" + name + ", gender=" + gender + ", age=" + age + ", weapon=" + weapon + "]";
	}

	
}

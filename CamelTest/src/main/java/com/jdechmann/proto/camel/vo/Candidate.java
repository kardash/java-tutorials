package com.jdechmann.proto.camel.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("candidate")
public class Candidate {
	
	private String name;
	private int age;
	private int size;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Candidate - " +
			" Name:" + name + 
			" Age:" + age + 
			" Size" + size;
	}
	
	

}

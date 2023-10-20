package com.ji.json001;

public class ParseObject {
	
	String name;
	String address;
	String number;
	String distance;
	
	public ParseObject() {
		super();
	}

	public ParseObject(String name, String address, String number, String distance) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
	
}

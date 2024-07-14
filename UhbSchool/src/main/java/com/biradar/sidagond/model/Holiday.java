package com.biradar.sidagond.model;

public class Holiday {

	private final String day;
	private final String reason;
	private Type type;
	
	
	public enum Type {

		FESTIVAL,FEDERAL;
	}


	public Holiday(String day, String reason, Type type) {
		super();
		this.day = day;
		this.reason = reason;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDay() {
		return day;
	}

	public String getReason() {
		return reason;
	}

}

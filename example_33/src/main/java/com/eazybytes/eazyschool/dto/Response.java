package com.eazybytes.eazyschool.dto;

public class Response {

	private String statusCode;
	private String statusMsg;
	
	

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

}

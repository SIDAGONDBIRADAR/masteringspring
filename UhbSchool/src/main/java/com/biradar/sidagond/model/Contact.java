package com.biradar.sidagond.model;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Contact {

	@NotBlank(message = "Name should not be blank")
	@Length(min=3,max = 50,message = "Name should be atleast 3 characters")
	private String name;
	
	@NotBlank(message = "Mobile Number should be blank")
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number should contains only numbers and must be 10 digits")
	private String mobileNum;
	
	@NotBlank(message="Email should be blank")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotBlank(message = "Subject should not be blank")
	@Size(max = 100,min=10,message = "Subject should be atleast 10 characters")
	private String subject;
	
	@NotBlank(message = "Message should not be blank")
	@Size(max = 500,min=20,message = "Message should be atleast 20 characters")
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobileNum=" + mobileNum + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + "]";
	}
	
	
	

}

package com.eazybytes.eazyschool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile {

	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String name;

	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please provide a valid email address")
	private String email;

	@NotBlank(message = "Mobile number must not be blank")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@NotBlank(message = "address1 cannot be blank")
	@Size(min = 5, message = "Address 1 should have atleast 5 characters")
	private String address1;
	private String address2;

	@NotBlank(message = "city cannot be blank")
	@Size(min = 5, message = "City should have atleast 5 characters")
	private String city;

	@NotBlank(message = "state cannot be blank")
	@Size(min = 5, message = "State should have atleast 5 characters")
	private String state;

	@NotBlank(message = "ZipCode cannot be blank")
	@Pattern(regexp = "(^$|[0-9]{6})", message = "Zipcode should be of 6 digits")
	private String zipCode;

}

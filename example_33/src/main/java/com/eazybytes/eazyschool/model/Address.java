package com.eazybytes.eazyschool.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native",strategy = "native")
	private Integer addressId;
	
	@NotBlank(message = "address1 cannot be blank")
	@Size(min = 5,message = "Address 1 should have atleast 5 characters")
	private String address1;
	private String address2;
	
	@NotBlank(message = "city cannot be blank")
	@Size(min = 5,message = "City should have atleast 5 characters")
	private String city;
	
	@NotBlank(message = "state cannot be blank")
	@Size(min = 5,message = "State should have atleast 5 characters")
	private String state;
	
	@NotBlank(message = "ZipCode cannot be blank")
	@Pattern(regexp = "(^$|[0-9]{6})",message = "Zipcode should be of 6 digits")
	private Integer zipCode;
}

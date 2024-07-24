package com.eazybytes.eazyschool.model;

import org.hibernate.annotations.GenericGenerator;

import com.eazybytes.eazyschool.annotations.FieldsValueMatch;
import com.eazybytes.eazyschool.annotations.PasswordValidator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@FieldsValueMatch.List({
		@FieldsValueMatch(field = "pwd", fieldMatch = "confirmPwd", message = "Password do not match!"),
		@FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Email addresses do not match!") })

public class Person extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer personId;

	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String name;

	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please provide a valid email address")
	private String email;

	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please provide a valid email address")
	@Transient
	private String confirmEmail;

	@NotBlank(message = "Mobile number must not be blank")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobileNumber;

	@NotBlank(message = "Password must not be blank")
	@Size(message = "Password must be atleast of 5 character")
	@PasswordValidator
	private String pwd;

	@NotBlank(message = "Password must not be blank")
	@Size(message = "Password must be atleast of 5 character")
	@Transient
	private String confirmPwd;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
	private Address address;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
	@JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
	private Roles roles;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name="class_id",referencedColumnName = "classId",nullable = true)
	private EazyClass eazyClass;
}

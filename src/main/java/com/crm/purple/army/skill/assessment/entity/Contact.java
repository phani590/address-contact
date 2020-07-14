package com.crm.purple.army.skill.assessment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Contact implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Please enter an name")
	@Size(min=2, max=30,message="name must be between 2 and 30 characters")
    private String name;
	
	@NotNull(message ="Please enter an email")
    @Email(message = "Please enter a valid e-mail address")
    private String email;
	
	@NotNull(message="Please enter an phoneNumber")
	@Size(min=2, max=30,message="phoneNumber must be 10 digits")
    private String phoneNumber;
    
    private static final long serialVersionUID = 1L;
   
    public Contact() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}

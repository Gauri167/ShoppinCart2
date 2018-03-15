package com.shop.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class User {

	@Id
	private String emailId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Mobile")
	private String mobile;
	
	@Column(name="Role")
	private char role;
	
	@Column(name="RegisterDate")
	private Date registerDate;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}

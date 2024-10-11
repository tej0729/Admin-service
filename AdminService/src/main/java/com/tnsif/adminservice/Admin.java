package com.tnsif.adminservice;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private int id;

	@Column(name = "username",nullable = false)
	private String username;

	@Column(name = "mobile",nullable = false)
	private String mobile;

	@Column(name = "email",nullable = false)
	private String email;

	@Column(name = "designation",nullable = false)
	private String designation;
	
	@Column(name = "address",nullable = false)
	private String address;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String username, String mobile, String email, String designation, String address) {
		super();
		this.id = id;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.designation = designation;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", mobile=" + mobile + ", email=" + email + ", designation=" + designation
				+ ", address=" + address + "]";
	}

}

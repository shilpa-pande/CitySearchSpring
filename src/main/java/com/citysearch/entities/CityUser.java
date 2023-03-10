package com.citysearch.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "city_user")
public class CityUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	
	private String name;
	
	 
	private String password;
	
	 @Column(unique = true)  
	private String email;
	  
	  
	private String address;
	private String country;
	private String contact;
	private String role;
	
	 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityuser")
	private List<CityClassified> cityclassified=new ArrayList<>();
	
	 
	 public CityUser() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<CityClassified> getCityclassified() {
		return cityclassified;
	}
	public void setCityclassified(List<CityClassified> cityclassified) {
		this.cityclassified = cityclassified;
	}
	
	
	
	

}

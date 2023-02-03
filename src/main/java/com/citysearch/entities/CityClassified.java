package com.citysearch.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "city_classified")
public class CityClassified {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	private String buysell;
	private String name ;
	private String description;
	
	@ManyToOne
	private CityUser cityuser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuysell() {
		return buysell;
	}
	public void setBuysell(String buysell) {
		this.buysell = buysell;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CityUser getCityuser() {
		return cityuser;
	}
	public void setCityuser(CityUser cityuser) {
		this.cityuser = cityuser;
	}
	
	
	

}

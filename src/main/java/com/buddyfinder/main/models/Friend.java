package com.buddyfinder.main.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private String location;
	private Date availability;
	private String activity;
	
	public Friend() {
		
	}
	
	public Friend(String id,String name, String location, Date availability, String activity) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.availability = availability;
		this.activity = activity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getAvailability() {
		return availability;
	}


	public void setAvailability(Date availability) {
		this.availability = availability;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
}

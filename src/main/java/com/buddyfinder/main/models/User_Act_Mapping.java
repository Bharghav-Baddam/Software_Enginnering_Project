package com.buddyfinder.main.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_Act_Mapping")

public class User_Act_Mapping {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( unique=true, nullable=false)
	private Integer map_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@Column(nullable=false)
    private Account account;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "act_id")
	@Column(nullable=false)
	private Activity activity;
	private String location;
	private Date date;
	public User_Act_Mapping() {
		
	}
	public User_Act_Mapping(Date date,String location,Account account,Activity activity) {
		this.date=date;
		this.location=location;
		this.account=account;
		this.activity=activity;
	}
	public Integer getMap_id() {
		return map_id;
	}
	public void setMap_id(Integer map_id) {
		this.map_id = map_id;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

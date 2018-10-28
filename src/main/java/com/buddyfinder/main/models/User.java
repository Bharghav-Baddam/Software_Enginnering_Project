package com.buddyfinder.main.models;

import javax.persistence.*;
@Entity
@Table(name = "user_info")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique=true, nullable=false)
	private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
    private Account account;
    private String username;
    private String gender;
    private String location;
    public User() {
    	
    }
    public User(String username,String gender,String location,Account account) {
    	this.username=username;
    	this.gender=gender;
    	this.location=location;
    	this.account=account;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
   
    

}

package com.buddyfinder.main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( unique=true, nullable=false)
	private Integer act_id;
	private String act_name;
	private String description;
	@OneToOne(mappedBy = "activity")
	private User_Act_Mapping user_Act_Mapping;
	public Activity() {
		
	}
	public Activity(String act_name,String description) {
		this.act_name=act_name;
		this.description=description;
	}
	public Integer getAct_id() {
		return act_id;
	}
	public void setAct_id(Integer act_id) {
		this.act_id = act_id;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User_Act_Mapping getUser_Act_Mapping() {
		return user_Act_Mapping;
	}
	public void setUser_Act_Mapping(User_Act_Mapping user_Act_Mapping) {
		this.user_Act_Mapping = user_Act_Mapping;
	}
	
	
}

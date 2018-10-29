package com.buddyfinder.main.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer activityId;

	@Column
	private String location;
	
	@Column
	private String description;
	
	@Column
	private String activityName;
	
	@Column
	private Date date;
	
	@ManyToOne
	private Account postedBy;
	
	@ManyToMany
	@JoinTable(name="activityAccount",
		joinColumns = @JoinColumn(name="activityId", referencedColumnName="activityId"),
		inverseJoinColumns = @JoinColumn(name="accountId", referencedColumnName="accountId"))
	private List<Account> attendedBy;
	
	
	public Activity() {
		
	}


	public Activity( String location, String description, String activityName, Date date,
			Account postedBy, List<Account> attendedBy) {
		super();
		this.location = location;
		this.description = description;
		this.activityName = activityName;
		this.date = date;
		this.postedBy = postedBy;
		this.attendedBy = attendedBy;
	}


	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Account getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(Account postedBy) {
		this.postedBy = postedBy;
	}


	public List<Account> getAttendedBy() {
		return attendedBy;
	}


	public void setAttendedBy(List<Account> attendedBy) {
		this.attendedBy = attendedBy;
	}
	
	
	
}

package com.buddyfinder.main.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Account")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String password;
	@Column(unique=true)
	private String email;
	@Column
	private String securityQuestion;
	@Column
	private String securityAnswer;
	@Column
	private String role;
	@Column
	private boolean blocked;


	//mappedBy is the name of the field of the linked Activity
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="postedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Activity> postedActivities;
	
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="attendedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Activity> attendedActivities;

	public Account() {
		
	}

	public Account( String firstName, String lastName, String password, String email,
			String securityQuestion, String securityAnswer, String role,
			List<Activity> postedActivities, List<Activity> attendedActivities) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.role = role;
		this.postedActivities = postedActivities;
		this.attendedActivities = attendedActivities;
		this.blocked = false;
	}

//	public Account(Integer accountId, String firstName, String lastName, String password, String email,
//			String securityQuestion, String securityAnswer, String role, Account account, List<Account> friends,
//			List<Activity> postedActivities, List<Activity> attendedActivities) {
//		super();
//		this.accountId = accountId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.password = password;
//		this.email = email;
//		this.securityQuestion = securityQuestion;
//		this.securityAnswer = securityAnswer;
//		this.role = role;
//		this.account = account;
//		this.friends = friends;
//		this.postedActivities = postedActivities;
//		this.attendedActivities = attendedActivities;
//	}


	
	public Integer getAccountId() {
		return accountId;
	}



	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}




	public List<Activity> getPostedActivities() {
		return postedActivities;
	}




	public List<Activity> getAttendedActivities() {
		return attendedActivities;
	}





	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void setPostedActivities(List<Activity> postedActivities) {
		this.postedActivities = postedActivities;
	}

	public void setAttendedActivities(List<Activity> attendedActivities) {
		this.attendedActivities = attendedActivities;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getSecurityQuestion() {
		return securityQuestion;
	}


	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}


	public String getSecurityAnswer() {
		return securityAnswer;
	}


	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	//@LazyCollection(LazyCollectionOption.FALSE)
/*	@OneToMany(mappedBy="wallPostOn", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Wall> wallPosts;

	public List<Wall> getWallPosts() {
		return wallPosts;
	}

	public void setWallPosts(List<Wall> wallPosts) {
		this.wallPosts = wallPosts;
	}*/

}

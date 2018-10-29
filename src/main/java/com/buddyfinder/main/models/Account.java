package com.buddyfinder.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@Column
	private String email;
	@Column
	private String securityQuestion;
	@Column
	private String securityAnswer;
	@Column
	private String role;
	

	@OneToMany(mappedBy="accountId")
	private List<Account> friends;
	
	//mappedBy is the name of the field of the linked Activity
	@OneToMany(mappedBy="postedBy")
	private List<Activity> postedActivities;
	
	@ManyToMany(mappedBy="attendedBy")
	private List<Activity> attendedActivities;


	public Account() {
		
	}


	public Account( String firstName, String lastName, String password, String email,
			String securityQuestion, String securityAnswer, String role,List<Account> friends,
			List<Activity> postedActivities, List<Activity> attendedActivities) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.role = role;
		this.friends = friends;
		this.postedActivities = postedActivities;
		this.attendedActivities = attendedActivities;
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




	public void setPostedActivities(ArrayList<Activity> postedActivities) {
		this.postedActivities = postedActivities;
	}




	public List<Activity> getAttendedActivities() {
		return attendedActivities;
	}




	public void setAttendedActivities(ArrayList<Activity> attendedActivities) {
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





	public List<Account> getFriends() {
		return friends;
	}


	public void setFriends(ArrayList<Account> friends) {
		this.friends = friends;
	}
	
	



	
}

package com.buddyfinder.main.models;

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
@Table(name = "Account")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( unique=true, nullable=false)
    private Integer user_id;
	private String user_name;
	private String true_name;
	private String password;
	private Integer phone_num;
	private String email_address;
	private String security_question;
	private String security_answer;
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "role_id")
	 @Column(nullable=false)
	private Role role;
	 @OneToOne(mappedBy = "account")
	 private User user;
	 @OneToOne(mappedBy = "account")
	 private User_Act_Mapping user_Act_Mapping;
	 
	private Integer isAbleToLogin;
	
	public Account() {
		
	}
	public Account(String user_name,String true_name,String password,Integer phone_num,String email_address,String security_question,String security_answer,Role role,Integer isAbleToLogin) {
		this.user_name=user_name;
		this.true_name=true_name;
		this.password=password;
		this.phone_num=phone_num;
		this.email_address=email_address;
		this.security_question=security_question;
		this.security_answer=security_answer;
		this.role=role;
		this.isAbleToLogin=isAbleToLogin;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(Integer phone_num) {
		this.phone_num = phone_num;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	public String getSecurity_answer() {
		return security_answer;
	}
	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}
		public Role getRole() {
		return role;
	}
	public void setRole(Role i) {
		this.role = i;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public User_Act_Mapping getUser_Act_Mapping() {
		return user_Act_Mapping;
	}
	public void setUser_Act_Mapping(User_Act_Mapping user_Act_Mapping) {
		this.user_Act_Mapping = user_Act_Mapping;
	}
	public Integer getIsAbleToLogin() {
		return isAbleToLogin;
	}
	public void setIsAbleToLogin(Integer isAbleToLogin) {
		this.isAbleToLogin = isAbleToLogin;
	}

	
}

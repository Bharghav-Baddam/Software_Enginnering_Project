package com.buddyfinder.main.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")

	public class Role {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column( unique=true, nullable=false)
	    private Integer id;
	 	private String name;
		@OneToOne(mappedBy = "role")
	 	private Account account;
	    private Integer privacyLevel;
	 	public Role() {
	 		
	 	}
	 	public Role(String name,Integer privacylevel) {
	 		this.name=name;
	 		this.privacyLevel=privacylevel;
	 	}
	    public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getPrivacyLevel() {
			return privacyLevel;
		}
		public void setPrivacyLevel(Integer privacyLevel) {
			this.privacyLevel = privacyLevel;
		}
	
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		
		

	   
	  
}

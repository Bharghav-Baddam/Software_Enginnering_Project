package com.buddyfinder.main.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Wall {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;
	
	@OneToOne
	private Account wallPostOn;
	
	@OneToOne
	private Account wallPostBy;

	private Date date;
	
	private String text;
	
	@Lob 
    @Column(length=10000000)
    private byte[] image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
 
	public Account getWallPostOn() {
		return wallPostOn;
	}

	public void setWallPostOn(Account wallPostOn) {
		this.wallPostOn = wallPostOn;
	}

	public Account getWallPostBy() {
		return wallPostBy;
	}

	public void setWallPostBy(Account wallPostBy) {
		this.wallPostBy = wallPostBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}

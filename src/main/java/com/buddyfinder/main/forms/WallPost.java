package com.buddyfinder.main.forms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.buddyfinder.main.models.Account;

import java.util.ArrayList;


public class WallPost {

	private Integer id;
	private String content;
	private byte[] file;
	private String img;
	private Account postedBy;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Account getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(Account postedBy) {
		this.postedBy = postedBy;
	}
	
}

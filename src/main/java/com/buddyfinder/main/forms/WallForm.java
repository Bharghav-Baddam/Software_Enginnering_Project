package com.buddyfinder.main.forms;

import org.springframework.web.multipart.MultipartFile;

public class WallForm {

	private String content;
	private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public WallForm(String content) {
		super();
		this.content = content;
	}
	public WallForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

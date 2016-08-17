package com.nisum.blog.model;

import java.time.LocalDateTime;

public class Comment {
	
	private String message;
	private String userName;
	private String userEmail;
	private int id;
	private LocalDateTime date;
	private String userUrl;

	public Comment(){}

	public Comment(int i){
		this.date=LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setMessage(String message){		
		this.message = message;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
}
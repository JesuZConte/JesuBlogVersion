package com.nisum.blog.model;

import java.util.ArrayList;
import java.util.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private Date date;
	private Author author;
	private ArrayList<String> tags;
	private ArrayList<Comment> comments;
	
	public News(){ 
		setComments(new ArrayList<Comment>());
		setTags(new ArrayList<String>());
	}
	
	public News(int id, String title, String content, Author author) {
		setId(id);
		setTitle(title);
		setContent(content);
		setDate(date);
		setAuthor(author);
		setTags(new ArrayList<String>());
		setComments(new ArrayList<Comment>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = new Date();
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}


	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

}

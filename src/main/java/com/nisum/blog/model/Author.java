package com.nisum.blog.model;


public class Author{
	
	private String name;
	private String mail;
	private int id;
	
	public Author(){}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return  id + "," + name + "," + mail;
	}
	
	
	
	
	
}

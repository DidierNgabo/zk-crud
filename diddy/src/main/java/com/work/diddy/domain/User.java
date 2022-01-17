package com.work.diddy.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	 @Id
	    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int id;
	private String name;
	private String role;
	private Date date;
	
	
	
	
	public User() {
		super();
	}

	public User(int id, String name, String role, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

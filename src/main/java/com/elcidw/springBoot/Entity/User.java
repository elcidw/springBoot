package com.elcidw.springBoot.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "User.findByName", query = "select name,course from User u where u.name=?1")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	long id;
	@Column(name="name")
	private String name;
	@Column(name="course")
	private String course;
	
	public long getId() {
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}

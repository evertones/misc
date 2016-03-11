package org.evertones.model;

import java.time.LocalDate;

public class Person {

	private int id;
	private String firstName;
	private String surName;
	private LocalDate birthday;
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static int nameCompare(Person a1, Person a2) {
		return a1.getFirstName().compareTo(a2.getFirstName());
	}
	
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getSurName();
	}
}

package org.evertones.model;

import java.time.LocalDate;

public class Employee extends Person{

	private double annualPackage;
	private LocalDate startDate;
	private LocalDate endDate;
	private String role;

	public double getAnnualPackage() {
		return annualPackage;
	}
	public void setAnnualPackage(double annualPackage) {
		this.annualPackage = annualPackage;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

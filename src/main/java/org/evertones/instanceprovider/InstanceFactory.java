package org.evertones.instanceprovider;

import java.time.LocalDate;
import java.util.List;

import org.evertones.model.Employee;
import org.evertones.model.Person;
import org.evertones.model.Person.Gender;
import org.evertones.model.Person.PlaceOfBirth;

public class InstanceFactory {

	public Person getPerson(String firstName, String lastName, Gender sex, LocalDate birthday, PlaceOfBirth birthContinent) {
		return new PersonProvider().getSimplePerson(firstName, lastName, sex, birthday, birthContinent);
	}
	
	public Person getPerson() {
		return new PersonProvider().getPerson();
	}
	
	public Employee getEmployee() {
		return new EmployeeProvider().getEmployee();
	}
	
	public List<Person> getPersonList() {
		return new PersonProvider().getPersonList();
	}
	
	public List<Employee> getEmployeeList() {
		return new EmployeeProvider().getEmployeeList();
	}
	
}

package org.evertones.instanceprovider;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.evertones.model.Person;
import org.evertones.model.Person.Gender;
import org.evertones.model.Person.PlaceOfBirth;

public class PersonProvider {

	public List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(this.getSimplePerson("Barack", "Obama", Gender.MALE, 
				LocalDate.of(9161, Month.AUGUST, 4), PlaceOfBirth.AMERICA));
		personList.add(this.getSimplePerson("Michele", "Obama", Gender.FEMALE, 
				LocalDate.of(1964, Month.JANUARY, 17), PlaceOfBirth.AMERICA));
		personList.add(this.getSimplePerson("Bill", "Clinton", Gender.MALE, 
				LocalDate.of(1846, Month.AUGUST, 19), PlaceOfBirth.AMERICA));
		personList.add(this.getSimplePerson("Hillary", "Clinton", Gender.FEMALE, 
				LocalDate.of(1947, Month.OCTOBER, 26), PlaceOfBirth.AMERICA));
		personList.add(this.getSimplePerson("Vladmir", "Puttin", Gender.MALE, 
				LocalDate.of(1952, Month.OCTOBER, 7), PlaceOfBirth.EUROPE));
		personList.add(this.getSimplePerson("Angela", "Merkel", Gender.FEMALE, 
				LocalDate.of(1954, Month.JULY, 17), PlaceOfBirth.EUROPE));
		personList.add(this.getSimplePerson("Xi", "Jinping", Gender.MALE, 
				LocalDate.of(1953, Month.JUNE, 15), PlaceOfBirth.ASIA));
		personList.add(this.getSimplePerson("Nelson", "Mandela", Gender.MALE, 
				LocalDate.of(1918, Month.JULY, 18), PlaceOfBirth.AFRICA));
		
		return personList;
	}
	
	public Person getSimplePerson(String firstName, String lastName, Gender sex, 
			LocalDate birthday, PlaceOfBirth birthContinent) {
		
		Person p = new Person();
		p.setFirstName(firstName);
		p.setSurName(lastName);
		p.setSex(sex);
		p.setBirthday(birthday);
		p.setBirthContinent(birthContinent);
		
		return p;
	}
	
	public Person getPerson() {
		Person p = new Person();
		p.setId(1);
		p.setFirstName("John");
		p.setSurName("Smiths");
		p.setEmail("john.smiths302@gmail.com");
		p.setBirthday(LocalDate.of(1976, Month.AUGUST, 04));
		p.setSex(Gender.MALE);
		
		return p;
	}
	
}

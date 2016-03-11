package org.evertones.util.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.evertones.lambda.FunctionalInterface1;
import org.evertones.lambda.FunctionalInterface2;
import org.evertones.model.Employee;
import org.evertones.model.Person;
import org.junit.Assert;
import org.junit.Test;

public class LambdaExpressionsTest {
	
	@Test
	public void functionalInterfaceTrue() throws Exception {
		FunctionalInterface1 fi = () -> ("1".equals(Integer.valueOf(1).toString()) );
		Assert.assertTrue(fi.getValue());
	}
	
	@Test
	public void functionalInterfaceFalse() throws Exception {
		Employee e = this.createEmployee();
		
		FunctionalInterface1 fi = () -> ( e.getAnnualPackage() > 90000d );
		Assert.assertFalse(fi.getValue());
	}
	
	@Test
	public void personFullname() throws Exception {
		Person p = this.createPerson();
		FunctionalInterface2<Person> fi = (t) -> (t.getFirstName() + " " + t.getSurName());
		Assert.assertTrue("John Smiths".equals(fi.test(p)));
	}
	
	@Test
	public void employeeHasValidStartDate() throws Exception {
		Employee e = this.createEmployee();
		FunctionalInterface2<Employee> fi = (t) -> (t.getStartDate().isBefore(LocalDate.now()) ? "Good" : "Bad");
		Assert.assertTrue("Good".equals(fi.test(e)));
	}
	
	@Test
	public void convertListToString() throws Exception {
		List<Person> personList = this.createSimplePersonList();

		StringBuilder members = new StringBuilder();
		personList.forEach(t -> members.append(t.getFirstName() + " ") );

		Assert.assertEquals("Barack Michele Bill Hillary Vladmir Angela ", members.toString());
	}
	
	@Test
	public void orderList() throws Exception {
		List<Person> personList = this.createSimplePersonList();
		
		Assert.assertEquals("[Barack Obama, Michele Obama, Bill Clinton, Hillary Clinton, Vladmir Puttin, Angela Merkel]", personList.toString());
		
		System.out.println(personList.toString());
		personList.sort(Person::nameCompare);
		System.out.println(personList.toString());
		
		Assert.assertEquals("[Angela Merkel, Barack Obama, Bill Clinton, Hillary Clinton, Michele Obama, Vladmir Puttin]", personList.toString());
	}

	/**
	 * --------------------------------------------------------------
	 * Helper methods
	 * --------------------------------------------------------------
	 */
	
	private Person createSimplePerson(String firstName, String lastName) {
		Person p = new Person();
		p.setFirstName(firstName);
		p.setSurName(lastName);
		
		return p;
	}
	
	private List<Person> createSimplePersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(this.createSimplePerson("Barack", "Obama"));
		personList.add(this.createSimplePerson("Michele", "Obama"));
		personList.add(this.createSimplePerson("Bill", "Clinton"));
		personList.add(this.createSimplePerson("Hillary", "Clinton"));
		personList.add(this.createSimplePerson("Vladmir", "Puttin"));
		personList.add(this.createSimplePerson("Angela", "Merkel"));
		
		return personList;
	}
	
	private Person createPerson() {
		Person p = new Person();
		p.setId(1);
		p.setFirstName("John");
		p.setSurName("Smiths");
		p.setEmail("john.smiths302@gmail.com");
		p.setBirthday(LocalDate.of(1976, Month.AUGUST, 04));
		
		return p;
	}
	
	private Employee createEmployee() {
		Employee e = new Employee();
		e.setId(2);
		e.setFirstName("George");
		e.setSurName("Brandson");
		e.setEmail("g.brandson111@gmail.com");
		e.setBirthday(LocalDate.of(1964, Month.JANUARY, 17));
		
		e.setAnnualPackage(80000d);
		e.setRole("Civil Engineer");
		e.setStartDate(LocalDate.of(2004, Month.NOVEMBER, 01));
		
		return e;
	}
}

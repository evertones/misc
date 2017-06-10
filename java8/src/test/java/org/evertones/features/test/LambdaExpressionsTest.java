package org.evertones.features.test;

import java.time.LocalDate;
import java.util.List;

import org.evertones.features.lambda.FunctionalInterface1;
import org.evertones.features.lambda.FunctionalInterface2;
import org.evertones.instanceprovider.InstanceFactory;
import org.evertones.model.Employee;
import org.evertones.model.Person;
import org.junit.Assert;
import org.junit.Test;

public class LambdaExpressionsTest {
	
	InstanceFactory factory = new InstanceFactory();
	
	@Test
	public void functionalInterfaceTrue() throws Exception {
		FunctionalInterface1 fi = () -> ("1".equals(Integer.valueOf(1).toString()) );
		Assert.assertTrue(fi.getValue());
	}
	
	@Test
	public void functionalInterfaceFalse() throws Exception {
		Employee e = factory.getEmployee();
		
		FunctionalInterface1 fi = () -> ( e.getAnnualPackage() > 90000d );
		Assert.assertFalse(fi.getValue());
	}
	
	@Test
	public void personFullname() throws Exception {
		Person p = factory.getPerson();
		FunctionalInterface2<Person> fi = (t) -> (t.getFirstName() + " " + t.getSurName());
		Assert.assertTrue("John Smiths".equals(fi.test(p)));
	}
	
	@Test
	public void employeeHasValidStartDate() throws Exception {
		Employee e = factory.getEmployee();
		FunctionalInterface2<Employee> fi = (t) -> (t.getStartDate().isBefore(LocalDate.now()) ? "Good" : "Bad");
		Assert.assertTrue("Good".equals(fi.test(e)));
	}
	
	@Test
	public void convertListToString() throws Exception {
		List<Person> personList = factory.getPersonList();

		StringBuilder members = new StringBuilder();
		personList.forEach(t -> members.append(t.getFirstName() + " ") );

		Assert.assertEquals("Barack Michele Bill Hillary Vladmir Angela Xi Nelson ", members.toString());
	}
	
	@Test
	public void orderList() throws Exception {
		List<Person> personList = factory.getPersonList();
		
		Assert.assertEquals("[Barack Obama, Michele Obama, Bill Clinton, Hillary Clinton, Vladmir Puttin, Angela Merkel, Xi Jinping, Nelson Mandela]", personList.toString());
		
		System.out.println(personList.toString());
		personList.sort(Person::nameCompare);
		System.out.println(personList.toString());
		
		Assert.assertEquals("[Angela Merkel, Barack Obama, Bill Clinton, Hillary Clinton, Michele Obama, Nelson Mandela, Vladmir Puttin, Xi Jinping]", personList.toString());
	}

}

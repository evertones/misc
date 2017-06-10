package org.evertones.instanceprovider;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.evertones.model.Employee;

public class EmployeeProvider {
	
	public Employee getEmployee() {
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
	
	public List<Employee> getEmployeeList() {
		throw new UnsupportedOperationException("Method not implemented");
	}

}

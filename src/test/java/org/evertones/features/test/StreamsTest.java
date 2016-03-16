package org.evertones.features.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import org.evertones.instanceprovider.InstanceFactory;
import org.evertones.model.Person;
import org.evertones.model.Person.Gender;
import org.evertones.model.Person.PlaceOfBirth;
import org.junit.Test;

import junit.framework.Assert;

public class StreamsTest {
	
	private Integer[] numbers = { 1, 7, 3, 6, 5, 2, 9, 1, 4, 0, 8, 5, 3, 6, 1, 3, 2, 6, 8, 7, 9, 0, 3 };
	private final List<Integer> list = Arrays.asList(numbers);
	
	private InstanceFactory factory = new InstanceFactory();

	@Test
	public void showWomenNames() throws Exception {
		List<Person> personList = factory.getPersonList();
		
		List<String> ladiesList = 
				personList.stream()
				.filter(t -> t.getSex() == Gender.FEMALE)
				.sorted(Person::nameCompare)
				.map(Person::getFirstName)
				.collect(Collectors.toList());
		
		System.out.println("\n# Ladies list");
		System.out.println("-------------------------------------");
		ladiesList.forEach( t -> System.out.println(t.toString()) );
		
		Assert.assertEquals(3, ladiesList.size());
	}
	
	@Test
	public void showWomenNamesFromAmerica() throws Exception {
		List<Person> personList = factory.getPersonList();
		
		List<String> womenFromAmericaList = 
				personList.stream()
				.filter(t -> t.getSex() == Gender.FEMALE)
				.filter(t -> t.getBirthContinent() == PlaceOfBirth.AMERICA)
				.sorted(Person::nameCompare)
				.map(Person::getFirstName)
				.collect(Collectors.toList());
		
		System.out.println("\n# America ladies list");
		System.out.println("-------------------------------------");
		womenFromAmericaList.forEach( t -> System.out.println(t.toString()) );
		
		Assert.assertEquals(2, womenFromAmericaList.size());
	}
	
	@Test()
	public void filterPeopleFromAfrica() throws Exception {
		this.filterPeople(PlaceOfBirth.AFRICA, "# Africa born people", 1);
	}
	
	@Test()
	public void filterPeopleFromAmerica() throws Exception {
		this.filterPeople(PlaceOfBirth.AMERICA, "# America born people", 4);
	}
	
	@Test()
	public void filterPeopleFromAsia() throws Exception {
		this.filterPeople(PlaceOfBirth.ASIA, "# Asia born people", 1);
	}
	
	@Test()
	public void filterPeopleFromEurope() throws Exception {
		this.filterPeople(PlaceOfBirth.EUROPE, "# Europe born people", 2);
	}
	
	@Test
	public void getDistinctNumbers() {
		List<Integer> distinctNumbers = list
				.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println("\n-----------------------------------------");
		System.out.println("DISTINCT ELEMENTS");
		distinctNumbers.forEach( t -> System.out.println("Distinct: " + t) );
		
		Set<Integer> checkSet = new HashSet<Integer>();
		boolean unique = false;
		for (Integer nro : distinctNumbers) {
			unique = checkSet.add(nro);
			if (!unique) break;
		}
		Assert.assertEquals(true, unique);
	}
	
	@Test
	public void showTop5Elements() throws Exception {
		List<Integer> first5Elements = list
				.stream()
				.limit(5)
				.collect(Collectors.toList());

		System.out.println("\n-----------------------------------------");
		System.out.println("FIST 5 ELEMENTS");
		first5Elements.forEach( t -> System.out.println("Limit: " + t) );
		Assert.assertEquals(5, first5Elements.size());
	}
	
	@Test
	public void elementsValueSmallerThan15() throws Exception {
		boolean exists = list
				.stream()
				.allMatch( g -> g <= 15 );

		// If all elements are smaller than 15, then return true
		Assert.assertEquals(true, exists);
	}
	
	@Test
	public void filterElementBetweenTwoValues() throws Exception {
		List<Integer> numbers = list
				.stream()
				.filter( t -> (t>3 && t<7) )
				.distinct()
				.sorted()
				.collect(Collectors.toList());
				
		Assert.assertEquals(3, numbers.size());
		Assert.assertEquals(Integer.valueOf(4), numbers.get(0));
		Assert.assertEquals(Integer.valueOf(5), numbers.get(1));
		Assert.assertEquals(Integer.valueOf(6), numbers.get(2));
	}
	
	@Test
	public void getMaxValueFromList() throws Exception {
		OptionalInt maxValue = list
				.stream()
				.mapToInt(Integer::intValue)
				.max();
		Assert.assertEquals(9, maxValue.orElse(0));
	}
	
	@Test
	public void getMinValueFromList() throws Exception {
		OptionalInt minValue = list
				.stream()
				.mapToInt(Integer::intValue)
				.min();
		Assert.assertEquals(0, minValue.orElse(9));
	}
	
	@Test
	public void getAverageFromList() throws Exception {
		Integer[] intArray = {3, 5, 7};
		List<Integer> intList = Arrays.asList(intArray);
		
		OptionalDouble avgValue = intList
				.stream()
				.mapToInt(Integer::intValue)
				.average();
		Assert.assertEquals(5d, avgValue.orElse(9));
	}
	
	/**
	 * -----------------------------------------------------------------
	 *  Helper Methods
	 * -----------------------------------------------------------------
	 */
	
	private void filterPeople(PlaceOfBirth birthContinent, String messageHeader, int assertionValue) {
		List<Person> personList = factory.getPersonList();
		
		List<String> list = personList.stream()
				.filter(t -> t.getBirthContinent() == birthContinent)
				.sorted(Person::nameCompare)
				.map(Person::getFirstName)
				.collect(Collectors.toList());
		
		System.out.println("\n" + messageHeader);
		System.out.println("-------------------------------------");
		list.forEach( t -> System.out.println(t.toString()) );
		Assert.assertEquals(assertionValue, list.size());
	}

}

package org.evertones.util.test;

import static org.junit.Assert.assertEquals;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.evertones.util.DateUtil;
import org.junit.Test;

/**
 * Unit test class to check some expected and unexpected behaviors from method calls. 
 * 
 * @author Everton
 *
 */
public class DateTest {
	
	@Test()
	public void daysInNormalYear() {
		long result = DateUtil.daysBetweenDates("01/01/2015", "01/01/2016");
		System.out.println("[testDiffDays1] Result: " + result);
		
		assertEquals(365L, result);
	}
	
	@Test()
	public void daysInBissextileTheYear() {
		long result = DateUtil.daysBetweenDates("01/01/2016", "01/01/2017");
		System.out.println("[testDiffDays2] Result: " + result);
		
		assertEquals(366L, result);
	}
	
	@Test()
	public void daysBetween2RandomStringDates() {
		long result = DateUtil.daysBetweenDates("04/11/1981", "06/06/1982");
		System.out.println("[testDiffDays3] Result: " + result);
		
		assertEquals(214L, result);
	}
	
	@Test()
	public void monthsBetweenFirstAndLastDayOfTheYear() {
		long result = DateUtil.monthsBetweenDates("01/01/2016", "31/12/2016");
		System.out.println("[testDiffMonths1] Result: " + result);
		
		assertEquals(11L, result);
	}
	
	@Test()
	public void monthsBetween2RandomStringDates() {
		long result = DateUtil.monthsBetweenDates("04/11/1981", "06/06/1982");
		System.out.println("[testDiffMonths2] Result: " + result);
		
		assertEquals(7L, result);
	}
	
	@Test()
	public void yearsBetweenFirstAndLastDayOfTheYear() {
		long result = DateUtil.yearsBetweenDates("01/01/2016", "31/12/2016");
		System.out.println("[testDiffYears1] Result: " + result);
		
		assertEquals(0L, result);
	}
	
	@Test()
	public void yearsBetweenFirstDayOfYear1AndFirstDayOfYear2() {
		long result = DateUtil.yearsBetweenDates("01/01/2016", "01/01/2017");
		System.out.println("[testDiffYears2] Result: " + result);
		
		assertEquals(1L, result);
	}
	
	@Test()
	public void yearsBetween2RandomDates() {
		long result = DateUtil.yearsBetweenDates("04/11/1981", "02/03/2016");
		System.out.println("[testDiffYears3] Result: " + result);
		
		assertEquals(34L, result);
	}
	
	@Test()
	public void negativeYearsBetween2RandomDates() {
		long result = DateUtil.yearsBetweenDates("02/03/2016", "04/11/1981");
		System.out.println("[testDiffYears4] Result: " + result);
		
		assertEquals(-34L, result);
	}
	
	@Test()
	public void stringFromDateInFormatddMMyyyy() {
		LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 01);
		String result = DateUtil.textFromDate(date, "dd/MM/yyyy");
		System.out.println("[testTextFromDate1] Result: " + result);
		
		assertEquals("01/02/2016", result);
	}
	
	@Test()
	public void stringFromDateInFormatMMddyyyy() {
		LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 01);
		String result = DateUtil.textFromDate(date, "MM/dd/yyyy");
		System.out.println("[testTextFromDate2] Result: " + result);
		
		assertEquals("02/01/2016", result);
	}
	
	@Test(expected=DateTimeException.class)
	public void throwsExceptionFromInvalidDate() {
		LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 30);
		String result = DateUtil.textFromDate(date, "dd/MM/yyyy");
		System.out.println("[testTextFromDate3] Result: " + result);
		
		assertEquals("30/02/2016", result);
	}
	
	@Test()
	public void compareEqualDatesFrom2DifferentInstances() {
		LocalDate date = LocalDate.of(1981, Month.NOVEMBER, 04);
		LocalDate result = DateUtil.dateFromText("04/11/1981", "dd/MM/yyyy");
		System.out.println("[testDateFromText1] Result: " + result);
		
		assertEquals(date, result);
	}
	
	@Test()
	public void expectFalseInDate1982AfterDate1981() {
		LocalDate date1 = LocalDate.of(1981, Month.NOVEMBER, 04);
		LocalDate date2 = LocalDate.of(1982, Month.JUNE, 06);
		
		boolean result = DateUtil.isDate1AfterDate2(date1, date2);
		System.out.println("[testDateAfterDate1] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectTrueInDate1982AfterDate1981() {
		LocalDate date1 = LocalDate.of(1982, Month.JUNE, 06);
		LocalDate date2 = LocalDate.of(1981, Month.NOVEMBER, 04);
		
		boolean result = DateUtil.isDate1AfterDate2(date1, date2);
		System.out.println("[testDateAfterDate2] Result: " + result);
		
		assertEquals(true, result);
	}
	
	@Test()
	public void expectFalseComparingAfterFinalDateWithNull() {
		LocalDate date1 = null;
		LocalDate date2 = LocalDate.of(1982, Month.JUNE, 06);
		
		boolean result = DateUtil.isDate1AfterDate2(date1, date2);
		System.out.println("[testDateAfterDate3] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectFalseComapringAfterInitialDateWithNull() {
		LocalDate date1 = LocalDate.of(1981, Month.NOVEMBER, 04);
		LocalDate date2 = null;
		
		boolean result = DateUtil.isDate1AfterDate2(date1, date2);
		System.out.println("[testDateAfterDate4] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectFalseComparingInitialDateAfterFinalDate() {
		LocalDate date1 = LocalDate.of(1981, Month.NOVEMBER, 04);
		LocalDate date2 = LocalDate.of(1982, Month.JUNE, 06);
		
		boolean result = DateUtil.isDate1AfterDate2(date1, date2);
		System.out.println("[testDateBeforeDate1] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectFalseComparingInitialDateBeforeFinalDate() {
		LocalDate date1 = LocalDate.of(1982, Month.JUNE, 06);
		LocalDate date2 = LocalDate.of(1981, Month.NOVEMBER, 04);
		
		boolean result = DateUtil.isDate1BeforeDate2(date1, date2);
		System.out.println("[testDateAfterDate2] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectFalseComapringBeforeFinalDateWithNull() {
		LocalDate date1 = null;
		LocalDate date2 = LocalDate.of(1982, Month.JUNE, 06);
		
		boolean result = DateUtil.isDate1BeforeDate2(date1, date2);
		System.out.println("[testDateBeforeDate3] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void expectFalseComapringBeforeInitialDateWithNull() {
		LocalDate date1 = LocalDate.of(1981, Month.NOVEMBER, 04);
		LocalDate date2 = null;
		
		boolean result = DateUtil.isDate1BeforeDate2(date1, date2);
		System.out.println("[testDateBeforeDate4] Result: " + result);
		
		assertEquals(false, result);
	}
	
	@Test()
	public void diffInTimemillisBetweenDates() {
		LocalDateTime date1 = LocalDateTime.of(1981, Month.NOVEMBER, 4, 0, 0);
		LocalDateTime date2 = LocalDateTime.of(1982, Month.JUNE, 6, 0, 0);
		
		long result = DateUtil.diffInMilliseconds(date1, date2);
		System.out.println("[testDiffTimeMillis1] Result: " + result);
		
		assertEquals(18489600000L, result);
	}
}

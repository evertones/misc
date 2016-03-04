package org.evertones.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Simple class to perform some operations using Java8 new libraries for Date and DateTime.
 * 
 * @author Everton
 *
 */
public class DateUtil {
	
	public enum DateTemporalDiff {
		DAYS, MONTHS, YEARS
	};

	public static long daysBetweenDates(String date1, String date2) {
		return diffBetween(date1, date2, DateTemporalDiff.DAYS);
	}
	
	public static long monthsBetweenDates(String date1, String date2) {
		return diffBetween(date1, date2, DateTemporalDiff.MONTHS);
	}
	
	public static long yearsBetweenDates(String date1, String date2) {
		return diffBetween(date1, date2, DateTemporalDiff.YEARS);
	}
	
	private static long diffBetween(String date1, String date2, DateTemporalDiff temporal) {
		LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		long diff = 0L;
		switch(temporal) {
			case DAYS: 
				diff = ChronoUnit.DAYS.between(d1, d2);
				break;
			case MONTHS: 
				diff = ChronoUnit.MONTHS.between(d1, d2);
				break;
			case YEARS: 
				diff = ChronoUnit.YEARS.between(d1, d2);
				break;
		}
		return diff;
	}
	
	/**
	 * Method to return a formated string from a LocalDate received as parameter.  
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String textFromDate(LocalDate date, String dateFormat) {
		return date.format(DateTimeFormatter.ofPattern(dateFormat));
	}
	
	/**
	 * Method to return a LocalDate from a formated string received as parameter.
	 * 
	 * @param textDate
	 * @param dateFormat
	 * @return
	 */
	public static LocalDate dateFromText(String textDate, String dateFormat) {
		LocalDate date = LocalDate.parse(textDate, DateTimeFormatter.ofPattern(dateFormat));
		return date;
	}
	
	/**
	 * Method to test if first parameter (LocalDate) is a date after the second parameter (LocalDate).
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isDate1AfterDate2(LocalDate date1, LocalDate date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		return date1.isAfter(date2);
	}
	
	/**
	 * Method to test if first parameter (LocalDate) is a date before the second parameter (LocalDate).
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isDate1BeforeDate2(LocalDate date1, LocalDate date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		return date1.isBefore(date2);
	}
	
	/**
	 * Method to return the difference in milliseconds between two dates.
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long diffInMilliseconds(LocalDateTime date1, LocalDateTime date2) {
		return ChronoUnit.MILLIS.between(date1, date2);
	}
}

package org.evertones.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Simple class to perform some operations using Java8 new libraries for Time.
 * 
 * @author Everton
 *
 */
public class TimeUtil {
	
	public enum TimeTemporalDiff {
		HOUR, MINUTE, SECOND, NANO
	}
	
	/**
	 * Method to truncated some specific unit of time.
	 * 
	 * @param time
	 * @param unit
	 * @return
	 */
	public static LocalTime truncateTime(LocalTime time, ChronoUnit unit) {
		return time.truncatedTo(unit);
	}
	
	/**
	 * Method to test if first parameter (LocalTime) is a time after the second parameter (LocalTime).
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isTime1AfterTime2(LocalTime time1, LocalTime time2) {
		if (time1 == null || time2 == null) {
			return false;
		}
		return time1.isAfter(time2);
	}
	
	/**
	 * Method to test if first parameter (LocalTime) is a time before the second parameter (LocalTime).
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isTime1BeforeTime2(LocalTime time1, LocalTime time2) {
		if (time1 == null || time2 == null) {
			return false;
		}
		return time1.isBefore(time2);
	}
	
	/**
	 * Method to add some unit of time to an existing time.
	 * 
	 * @param time
	 * @param timeToAdd
	 * @param temporalDiff
	 * @return
	 */
	public static LocalTime addTime(LocalTime time, long timeToAdd, TimeTemporalDiff temporalDiff) {
		LocalTime newTime = time;
		switch (temporalDiff) {
			case HOUR:
				newTime = time.plusHours(timeToAdd);
				break;
			case MINUTE:
				newTime = time.plusMinutes(timeToAdd);
				break;
			case SECOND:
				newTime = time.plusSeconds(timeToAdd);
				break;
			case NANO:
				newTime = time.plusNanos(timeToAdd);
				break;
		}
		return newTime;
	}

}

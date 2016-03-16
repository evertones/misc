package org.evertones.features.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.evertones.features.datetime.TimeUtil;
import org.evertones.features.datetime.TimeUtil.TimeTemporalDiff;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test class to check some expected and unexpected behaviors from method calls.
 * 
 * @author Everton
 *
 */
public class TimeTest {
	
	@Test()
	public void truncateSeconds() {
		LocalTime timeToTruncate = LocalTime.of(10, 15, 32, 443);
		LocalTime timeTruncated = LocalTime.of(10, 15, 32);
		LocalTime result = TimeUtil.truncateTime(timeToTruncate, ChronoUnit.SECONDS);
		
		assertEquals(timeTruncated, result);
	}
	
	@Test()
	public void truncateMinutes() {
		LocalTime timeToTruncate = LocalTime.of(10, 15, 32, 443);
		LocalTime timeTruncated = LocalTime.of(10, 15);
		LocalTime result = TimeUtil.truncateTime(timeToTruncate, ChronoUnit.MINUTES);
		
		assertEquals(timeTruncated, result);
	}
	
	@Test()
	public void truncateHours() {
		LocalTime timeToTruncate = LocalTime.of(10, 15, 32, 443);
		LocalTime timeTruncated = LocalTime.of(10, 00);
		LocalTime result = TimeUtil.truncateTime(timeToTruncate, ChronoUnit.HOURS);
		
		assertEquals(timeTruncated, result);
	}
	
	@Test()
	public void expectTime1AfterTime2() {
		LocalTime time1 = LocalTime.of(10, 15, 30, 50);
		LocalTime time2 = LocalTime.of(10, 15, 30, 30);
		
		Assert.assertTrue(TimeUtil.isTime1AfterTime2(time1, time2));
	}
	
	@Test()
	public void expectTime1BeforeTime2() {
		LocalTime time1 = LocalTime.of(10, 15, 30, 20);
		LocalTime time2 = LocalTime.of(10, 15, 30, 30);
		
		Assert.assertTrue(TimeUtil.isTime1BeforeTime2(time1, time2));
	}
	
	@Test()
	public void add15NanosInLocalTime() {
		LocalTime time = LocalTime.of(10, 20, 30, 40);
		LocalTime timeExpected = LocalTime.of(10, 20, 30, 55);
		LocalTime result = TimeUtil.addTime(time, 15, TimeTemporalDiff.NANO);
		
		assertEquals(timeExpected, result);
	}
	
	@Test()
	public void add15SecondsInLocalTime() {
		LocalTime time = LocalTime.of(10, 20, 30, 40);
		LocalTime timeExpected = LocalTime.of(10, 20, 45, 40);
		LocalTime result = TimeUtil.addTime(time, 15, TimeTemporalDiff.SECOND);
		
		assertEquals(timeExpected, result);
	}
	
	@Test()
	public void add15MinutesInLocalTime() {
		LocalTime time = LocalTime.of(10, 20, 30, 40);
		LocalTime timeExpected = LocalTime.of(10, 35, 30, 40);
		LocalTime result = TimeUtil.addTime(time, 15, TimeTemporalDiff.MINUTE);
		
		assertEquals(timeExpected, result);
	}
	
	@Test()
	public void add3HoursInLocalTime() {
		LocalTime time = LocalTime.of(10, 20, 30, 40);
		LocalTime timeExpected = LocalTime.of(13, 20, 30, 40);
		LocalTime result = TimeUtil.addTime(time, 3, TimeTemporalDiff.HOUR);
		
		assertEquals(timeExpected, result);
	}

}

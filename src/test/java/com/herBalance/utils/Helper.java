package com.herBalance.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
	private static Logger logger = LogManager.getLogger();
	public static int calculateCycleDay(String lastPeriod) {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		LocalDate periodDate = LocalDate.parse(lastPeriod, formatter);
		int daysBetween = (int)ChronoUnit.DAYS.between(periodDate, today) + 1;
		logger.info("Days between last period date and today:" + daysBetween);
		return daysBetween;
	}
	
	public static Double calculateCycleProgress(String lastPeriod, int cycleLength) {
		Double cycleDay = (double) calculateCycleDay(lastPeriod);
		logger.info("cycle day: " + cycleDay);
		String progress = String.format("%.4f", (cycleDay/cycleLength) * 100);
		logger.info("cycle day: " + cycleDay + "Bar Progress : " + progress);
		return Double.parseDouble(progress);
	}
	
	public static String calculateMenstrualPhase(String lastPeriod, int cycleLength) {
		int cycleDay = calculateCycleDay(lastPeriod);
		
		if (cycleDay >= 1 && cycleDay <= 5) {
			return "Menstrual Phase";
		}
		else if (cycleDay > 5 && cycleDay <= 13) {
			return "Follicular Phase";
		}
		else if (cycleDay > 13 && cycleDay <= 16) {
			return "Ovulation Phase";
		}
		else {
			return "Luteal Phase";
		}
	}
	
	public static String calculateNextPeriodExpected(String lastPeriod, int cycleLength) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		LocalDate periodDate = LocalDate.parse(lastPeriod, formatter);
		LocalDate expected = periodDate.plusDays(cycleLength);
		logger.info("Expected period date :" + expected);
		System.out.println("Expected period date :" + expected);
		return expected.format(formatter);
	}
	
	
}

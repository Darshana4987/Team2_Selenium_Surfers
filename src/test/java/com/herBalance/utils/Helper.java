package com.herBalance.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
	private static Logger logger = LogManager.getLogger();
	public static int calculateCycleDay() throws IOException {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		LocalDate periodDate = LocalDate.parse(lastPeriodDateFromTestData(), formatter);
		int daysBetween = (int)ChronoUnit.DAYS.between(periodDate, today) + 1;
		logger.info("Days between last period date and today:" + daysBetween);
		return daysBetween;
	}
	
	public static String calculateCycleProgress() throws IOException {
		Double cycleDay = (double) calculateCycleDay();
		int cycleLength = Integer.parseInt(cycleLengthFromTestData());
		logger.info("cycle day: " + cycleDay);
		String progress = String.format("%.4f", (cycleDay/cycleLength) * 100);
		logger.info("cycle day: " + cycleDay + "Bar Progress : " + progress);
		return progress;
	}
	
	public static String lastPeriodDateFromTestData() throws IOException {
		Map<String, String> row = ExcelReader.readExcelData("Onboarding", "Menstrual Data");
		return row.get("Last Period Date");
		
	}
	
	public static String cycleLengthFromTestData() throws IOException {
		Map<String, String> row = ExcelReader.readExcelData("Onboarding", "Menstrual Data");
		return row.get("Cycle Length");
	}
	
	public static String calculateMenstrualPhase() throws IOException {
		int cycleDay = calculateCycleDay();
		
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
	
	/*public static LocalDate calculateStartDateForEachPhase(String phase) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		LocalDate periodDate = LocalDate.parse(lastPeriodDateFromTestData(), formatter);
		String current = calculateMenstrualPhase();
		LocalDate today = LocalDate.now();
		
	}*/
	
	
	public static String calculateNextPeriodExpected() throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		LocalDate periodDate = LocalDate.parse(lastPeriodDateFromTestData(), formatter);
		int cycleLength = Integer.parseInt(cycleLengthFromTestData());
		LocalDate expected = periodDate.plusDays(cycleLength);
		logger.info("Expected period date :" + expected);
		return expected.format(formatter);
	}
	
	
}

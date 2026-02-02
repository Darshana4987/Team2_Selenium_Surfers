package com.herBalance.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Helper {
	public static String calculateCycleDay(String lastPeriod) {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		LocalDate periodDate = LocalDate.parse(lastPeriod, formatter);
		int daysBetween = (int)ChronoUnit.DAYS.between(periodDate, today);
		return Integer.toString(daysBetween);
	}
	
	public static double calculateCycleProgress(String lastPeriod, String cycleLength) {
		String cycleDay = calculateCycleDay(lastPeriod);
		return (Integer.parseInt(cycleDay) - Integer.parseInt(cycleLength)) / 100;
	}
}

package com.interview.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Date/Time API Examples (Java 8+)
 */
public class DateTimeExamples {
    
    public static void main(String[] args) {
        System.out.println("=== DATE/TIME API EXAMPLES (JAVA 8+) ===\n");
        
        // 1. LocalDate
        System.out.println("1. LOCALDATE");
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);
        LocalDate specificDate = LocalDate.of(2024, Month.JANUARY, 15);
        System.out.println("Specific date: " + specificDate);
        System.out.println("Day of week: " + specificDate.getDayOfWeek());
        System.out.println();
        
        // 2. LocalTime
        System.out.println("2. LOCALTIME");
        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);
        LocalTime specificTime = LocalTime.of(14, 30, 45);
        System.out.println("Specific time: " + specificTime);
        System.out.println();
        
        // 3. LocalDateTime
        System.out.println("3. LOCALDATETIME");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date-time: " + dateTime);
        LocalDateTime specificDateTime = LocalDateTime.of(2024, Month.JANUARY, 15, 14, 30);
        System.out.println("Specific date-time: " + specificDateTime);
        System.out.println();
        
        // 4. ZonedDateTime
        System.out.println("4. ZONEDDATETIME");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current zoned date-time: " + zonedDateTime);
        ZonedDateTime parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("Paris time: " + parisTime);
        System.out.println();
        
        // 5. Instant
        System.out.println("5. INSTANT");
        Instant instant = Instant.now();
        System.out.println("Current instant: " + instant);
        System.out.println("Epoch seconds: " + instant.getEpochSecond());
        System.out.println();
        
        // 6. Duration and Period
        System.out.println("6. DURATION AND PERIOD");
        LocalDateTime start = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 1, 1, 12, 30);
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration);
        System.out.println("Hours: " + duration.toHours());
        
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period);
        System.out.println("Months: " + period.getMonths());
        System.out.println();
        
        // 7. DateTimeFormatter
        System.out.println("7. DATETIMEFORMATTER");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted: " + formatted);
        
        LocalDateTime parsed = LocalDateTime.parse("2024-01-15 14:30:00", formatter);
        System.out.println("Parsed: " + parsed);
        System.out.println();
        
        // 8. ChronoUnit
        System.out.println("8. CHRONOUNIT");
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days between: " + daysBetween);
        long hoursBetween = ChronoUnit.HOURS.between(start, end);
        System.out.println("Hours between: " + hoursBetween);
    }
}


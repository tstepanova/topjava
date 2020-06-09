package ru.javawebinar.topjava.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static final String PATTERN = "yyyy-MM-dd HH:mm";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
    }

    public static String of(LocalDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }

    public static LocalDateTime of(String dateTime) {
        return LocalDateTime.parse(dateTime, FORMATTER);
    }

}

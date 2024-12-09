package com.si.sec10;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class S0105_DaysToVacations {
    public static void main(String[] args) {
        var now = LocalDate.now();
        var j1 = LocalDate.of(2025, Month.MARCH, 18);
        var days = ChronoUnit.DAYS.between(now, j1);
        System.out.println(days);

        var day = DayOfWeek.of(1).plus(2);
        System.out.println(day);
    }
}

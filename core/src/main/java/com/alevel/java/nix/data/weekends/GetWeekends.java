package com.alevel.java.nix.data.weekends;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetWeekends {

    public List<Integer> getWeekends(LocalDate startDate, LocalDate endDate) {
        var allDays = startDate.datesUntil(endDate)
                .collect(toList());
        var weekdays = new ArrayList<Integer>();
        for (int i = 0; i < allDays.size(); i++) {
            if ((allDays.get(i).getDayOfWeek() == DayOfWeek.SATURDAY)
                    || (allDays.get(i).getDayOfWeek()) == DayOfWeek.SUNDAY) {
                weekdays.add(i);
            }
        }
        return weekdays;
    }

}

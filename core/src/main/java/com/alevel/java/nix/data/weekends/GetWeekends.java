package com.alevel.java.nix.data.weekends;

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
            if (Integer.parseInt(String.valueOf(allDays.get(i).getDayOfWeek())) % 6 == 0
                    || Integer.parseInt(String.valueOf(allDays.get(i).getDayOfWeek())) % 7 == 0) {
                weekdays.add(i);
            }
        }
        return weekdays;
    }

}

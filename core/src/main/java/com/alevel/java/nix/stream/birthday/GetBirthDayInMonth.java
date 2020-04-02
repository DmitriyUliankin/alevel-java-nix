package com.alevel.java.nix.stream.birthday;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.groupingBy;

public class GetBirthDayInMonth {

    private final Map<Month, Integer> count;

    public GetBirthDayInMonth(Map<Month, Integer> count) {
        this.count = count;
    }

    public int get(Month month) {
        return count.getOrDefault(month, 0);
    }

    public GetBirthDayInMonth of(Collection<LocalDate> birthdays) {
        var count = birthdays.stream()
                .collect(groupingBy(
                        LocalDate::getMonth,
                        () -> new EnumMap<>(Month.class),
                        summingInt(date -> 1)
                ));

        return new GetBirthDayInMonth(count);
    }

}

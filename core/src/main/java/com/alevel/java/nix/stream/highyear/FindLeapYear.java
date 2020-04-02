package com.alevel.java.nix.stream.highyear;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FindLeapYear {

    public List<Year> findHighYear(Collection<Year> years) {
        return years.stream()
                .filter(Year::isLeap)
                .sorted()
                .collect(Collectors.toList());
    }

}

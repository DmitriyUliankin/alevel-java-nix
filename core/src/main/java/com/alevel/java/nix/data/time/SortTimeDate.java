package com.alevel.java.nix.data.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static java.util.stream.Collectors.*;

public class SortTimeDate {

    public SortedMap<LocalDate, SortedSet<LocalTime>> group(Collection<LocalDateTime> collection) {

        return collection.stream().collect(groupingBy(
                LocalDateTime::toLocalDate,
                TreeMap::new,
                mapping(LocalDateTime::toLocalTime, toCollection(TreeSet::new))
        ));
    }

}

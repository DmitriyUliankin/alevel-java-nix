package com.alevel.java.nix.stream.oddandeven;

import java.util.*;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;

public class OddAndEven {

    public Map<Boolean, SortedSet<Integer>> oddAndEven(int... numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .boxed()
                .collect(partitioningBy(
                        num -> num % 2 == 0,
                        toCollection(() -> new TreeSet<>(Comparator.reverseOrder())
                        )));

    }

}

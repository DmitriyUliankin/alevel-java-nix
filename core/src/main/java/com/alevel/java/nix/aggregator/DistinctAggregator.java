package com.alevel.java.nix.aggregator;

import java.util.Collections;
import java.util.HashSet;

public class DistinctAggregator<T2> implements Aggregator<Number, T2> {

    @Override
    public Number aggregate(T2[] items) {

        HashSet<T2> list = new HashSet<>();

        Collections.addAll(list, items);

        return list.size();
    }

}

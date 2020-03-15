package com.alevel.java.nix.aggregator;

import java.util.StringJoiner;

public class CSVAggregator<T2> implements Aggregator<String, T2> {

    @Override
    public String aggregate(T2[] items) {
        StringJoiner result = new StringJoiner(", ");
        for (T2 item : items) {
            result.add(item.toString());
        }
        return result.toString();
    }

}

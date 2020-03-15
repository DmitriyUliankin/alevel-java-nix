package com.alevel.java.nix.aggregator;

public class AvgAggregator<T2 extends Number> implements Aggregator<Double, T2> {

    @Override
    public Double aggregate(T2[] items) {
        int size = items.length;
        double sum = 0;
        for (T2 item : items) {
            sum += item.doubleValue();
        }
        return sum / size;
    }

}

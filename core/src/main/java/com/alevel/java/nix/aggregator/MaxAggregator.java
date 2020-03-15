package com.alevel.java.nix.aggregator;

import java.util.Comparator;

public class MaxAggregator<T1> implements Aggregator<T1, T1>, Comparator<T1> {

    private Object object;

    public MaxAggregator(Object object) {
        this.object = object;
    }

    @Override
    public T1 aggregate(T1[] items) {
        T1 max = items[0];
        for (T1 item : items) {
            if (compare(max, item) == -1) {
                max = item;
            }
        }
        return max;
    }

    @Override
    public int compare(T1 object1, T1 object2) {
        return (object1.hashCode() < object2.hashCode()) ? -1 : ((object1.equals(object2)) ? 0 : 1);
    }

}

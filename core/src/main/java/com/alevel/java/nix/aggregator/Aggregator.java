package com.alevel.java.nix.aggregator;

public interface Aggregator<T1, T2> {

    T1 aggregate(T2[] items);

}

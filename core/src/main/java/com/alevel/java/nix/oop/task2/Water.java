package com.alevel.java.nix.oop.task2;

public class Water extends Substance {

    @Override
    protected double getMeltingTemperature() {
        return 0.0;
    }

    @Override
    protected double getBoilingTemperature() {
        return 100.0;
    }
}

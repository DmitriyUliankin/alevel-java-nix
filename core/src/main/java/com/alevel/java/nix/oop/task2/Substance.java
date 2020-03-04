package com.alevel.java.nix.oop.task2;

public abstract class Substance implements Internals {

    private double temperature = 20.0;

    private double zeroCelsius = -273.15;

    protected abstract double getMeltingTemperature();

    protected abstract double getBoilingTemperature();


    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void heatUp(double t) {
        temperature = Math.max(temperature + t, zeroCelsius);
    }

    @Override
    public State getState() {
        State state;
        if (temperature > getBoilingTemperature()) {
            state = State.GAS;
        } else if (temperature > getMeltingTemperature()) {
            state = State.LIQUID;
        } else {
            state = State.SOLID;
        }
        return state;
    }
}

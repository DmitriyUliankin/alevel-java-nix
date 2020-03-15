package com.alevel.java.nix.retry;

public class RetryInTime<T> extends Retry<T> {

    private final int millis;

    public RetryInTime(int times, Block<T> block, int millis) {
        super(times, block);
        this.millis = millis;
    }

    @Override
    void waiting(int trying) {

        int sleepTime = millis * trying;

        try {
            checkMillis(millis);
            Thread.sleep(sleepTime);
        } catch (InterruptedException | CheckTimeException e) {
            e.printStackTrace();
        }
    }

    private void checkMillis(int millis) throws CheckTimeException {
        if (millis < 0) {
            throw new CheckTimeException("Time can't be negative");
        }
    }

}

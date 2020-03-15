package com.alevel.java.nix.retry;

public abstract class Retry<T> implements Block<T> {

    private final Block<T> block;

    private final int times;

    public Retry(int times, Block<T> block) {
        this.times = times;
        this.block = block;
    }

    @Override
    public T run() throws Exception {

        T type = (T) new Object();

        int trying = 1;

        if (times < trying) {
            throw new Exception("Attempts can't be more than max of attempts");
        }

        checkTimes(times);

        while (trying <= times) {
            try {
                block.run();
                waiting(trying);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            trying++;
        }
        return type;
    }

    abstract void waiting(int times) throws InterruptedException;

    private void checkTimes(int times) throws Exception {
        if (times < 1) {
            throw new Exception("Attempts can't be less than 1");
        }
    }

}

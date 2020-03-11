package com.alevel.java.nix.retry;

public abstract class Retry implements Block {

    private final Block block;

    private final int times;

    public Retry(int times, Block block) {
        this.times = times;
        this.block = block;
    }

    @Override
    public void run() throws Exception {

        int trying = 1;

        if (times < trying) {
            throw new Exception("Attempts can't be more than max of attempts");
        }

        checkTimes(times);

        while (trying <= times) {
            try {
                block.run();
                waiting(trying);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
            trying++;
        }
    }

    abstract void waiting(int times) throws InterruptedException;

    private void checkTimes(int times) throws Exception {
        if (times < 1) {
            throw new Exception("Attempts can't be less than 1");
        }
    }

}

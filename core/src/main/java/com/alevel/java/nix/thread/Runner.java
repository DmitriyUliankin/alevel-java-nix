package com.alevel.java.nix.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        try {
            var console = new Console(System.in, System.out, new StringBuilder(), new FileOutputStream(
                    new File("core/src/main/java/com/alevel/java/nix/thread/input.txt")));
            Thread thread = new Thread(console);

            thread.start();
            Thread.sleep(1000);
            String input = console.getInput().toString();
            StringBuilder builder = console.getBuilder();
            builder.replace(0, builder.length(), input);
            while (thread.isAlive()) {
                if (!input.equals(builder.toString())) {
                    console.writeFile();
                    console.getOutput().flush();
                    input = builder.toString();
                }
                builder.delete(0, builder.length());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}



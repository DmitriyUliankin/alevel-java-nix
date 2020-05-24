package com.alevel.java.nix.thread;

import java.io.*;
import java.util.Scanner;

public final class Console implements Runnable {

    private final InputStream input;

    private final StringBuilder builder;

    private final OutputStream output;

    private final PrintStream printer;

    public Console(InputStream input, PrintStream printer, StringBuilder builder, OutputStream output) {
        this.input = input;
        this.printer = printer;
        this.builder = builder;
        this.output = output;
    }

    @Override
    public void run() {
        var scanner = new Scanner(input);
        printer.println("Enter 'quit' to close input: ");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("quit")) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
                break;
            }
            printer.println("Continue input: ");
            builder.append(line);
        }
    }

    public void writeFile() {
        try {
            output.write(builder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public InputStream getInput() {
        return input;
    }

    public OutputStream getOutput() {
        return output;
    }

}

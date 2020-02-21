package com.alevel.java.nix.tic_tac_toe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Game {

    public static int[] canvas = {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    public static void main(String[] args) throws IOException {

        var viewer = new Viewer();
        var gameChecker = new GameChecker();
        var field = new Field();
        var loggerProcess = new LoggerProcess();

        File file = new File("/Users/mcmisle/Documents/A-Level/Maven/core/src/main/resources/tic-tac-toe.txt");
        FileWriter fileWriter = new FileWriter(file);

        boolean b;
        var isCurrentX = false;
        do {
            isCurrentX = !isCurrentX;
            viewer.drawCanvas();
            System.out.println("mark " + (isCurrentX ? "X" : "O"));
            var n = field.getNumber();
            canvas[n] = isCurrentX ? 1 : 2;
            b = !gameChecker.isGameOver(n);
            if (viewer.isDraw()) {
                System.out.println("Draw");
                return;
            }

            fileWriter.write(String.valueOf(loggerProcess.isDraw())+", ");

        } while (b);

        fileWriter.flush();
        fileWriter.close();

        viewer.drawCanvas();
        System.out.println();
        System.out.println("The winner is " + (isCurrentX ? "X" : "O") + "!");
    }
}
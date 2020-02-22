package com.alevel.java.nix.tic_tac_toe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {

    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private static final String FILENAME = "tic-tac-toe.txt";

    public static int[] canvas = {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };

    public static void main(String[] args) {

        var viewer = new Viewer();
        var gameChecker = new GameChecker();
        var field = new Field();
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

            log.info("next step");
            try {
                Files.readAllBytes(Paths.get(FILENAME));
            } catch (IOException e) {
                log.info("Failed to read file {}.", FILENAME, e);
            }

        } while (b);

        viewer.drawCanvas();
        System.out.println();
        System.out.println("The winner is " + (isCurrentX ? "X" : "O") + "!");
    }
}
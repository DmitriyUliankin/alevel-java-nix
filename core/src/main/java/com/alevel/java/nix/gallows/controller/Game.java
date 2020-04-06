package com.alevel.java.nix.gallows.controller;

import com.alevel.java.nix.gallows.model.Model;

import java.util.Scanner;

public final class Game {

    private static final int MAX_ATTEMPTS = 8;

    private Model model = new Model();

    public void startGame() {
        try (var input = new Scanner(System.in)) {
            model.readFileFromClasspath();
            model.blankWord();
            display(input);
        }
    }

    private void display(Scanner input) {
        System.out.println("Gallows game started! Try to guess the word below: " +
                "\n=>You have " + MAX_ATTEMPTS + " attempts");

        while (model.getMistakes() < MAX_ATTEMPTS) {
            System.out.println("\n" + model.buildWordFound());
            System.out.println("\nEnter a letter : ");
            var str = input.next();
            if (str.length() > 1) {
                str = str.substring(0, 1);
            }
            model.guessWord(str);
            System.out.println("\n" + model.buildWordFound());
            if (model.isWordFound()) {
                System.out.println("\nYou win!");
                break;
            } else {
                System.out.println("\n=> You have " + (MAX_ATTEMPTS - model.getMistakes()) + " attempts");
            }
        }
        if (model.getMistakes() == MAX_ATTEMPTS) {
            System.out.println("\nYou lose!");
            System.out.println("=> Word to find was : " + model.getWordToFind());
        }
    }

}

package com.alevel.java.nix.tictactoe;

public class Viewer implements Display {
    public void drawCanvas() {
        System.out.println("     |     |     ");
        for (int i = 0; i < Game.canvas.length; i++) {
            if (i != 0) {
                if (i % 3 == 0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                } else
                    System.out.print("|");
            }

            if (Game.canvas[i] == 0) System.out.print("  " + i + "  ");
            if (Game.canvas[i] == 1) System.out.print("  X  ");
            if (Game.canvas[i] == 2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

    public boolean isDraw() {
        for (int n : Game.canvas) if (n == 0){
            return false;
        }
        return true;
    }
}

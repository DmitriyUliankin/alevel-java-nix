package com.alevel.java.nix.tic_tac_toe;

public class GameChecker implements IsGameOver {
    public boolean isGameOver(int n) {
        int row = n - n % 3;
        if (Game.canvas[row] == Game.canvas[row + 1] &&
                Game.canvas[row] == Game.canvas[row + 2]) return true;
        int column = n % 3;
        if (Game.canvas[column] == Game.canvas[column + 3])
            if (Game.canvas[column] == Game.canvas[column + 6]) return true;
        if (n % 2 != 0) {
            return false;
        }
        if (n % 4 == 0) {
            if (Game.canvas[0] == Game.canvas[4] &&
                    Game.canvas[0] == Game.canvas[8]) return true;
            if (n != 4) return false;
        }
        return Game.canvas[2] == Game.canvas[4] &&
                Game.canvas[2] == Game.canvas[6];
    }
}

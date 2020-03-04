package com.alevel.java.nix.tictactoemvc.model;

import com.alevel.java.nix.tictactoemvc.view.View;

public class Model {

    private View view;
    private int playerId;
    private int movesCount;
    private char[][] board;
    private String message;

    public Model() {
        this.board = new char[3][3];
        this.movesCount = 9;
        this.playerId = 1;
    }

    public void registerView(View view) {
        this.view = view;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getMovesCount() {
        return movesCount;
    }

    public void setMovesCount(int movesCount) {
        this.movesCount = movesCount;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void playMove(int x, int y) {

        if (getMovesCount() > 0) {
            if (playerId % 2 != 0) {
                board[x][y] = 'X';
            } else {
                board[x][y] = 'O';
            }
            setMovesCount(--movesCount);

            if (isWinner(x, y)) {
                setMessage("Player " + playerId + " is Winner!");
                view.isWinner(x, y, board[x][y], getMessage());
            } else if (getMovesCount() == 0) {
                setMessage("No Winner! Game ended in a Tie");
                view.isWinner(x, y, board[x][y], getMessage());
            } else {
                if (playerId % 2 != 0) {
                    setPlayerId(2);
                    setMessage("'O':  Player " + getPlayerId());
                } else {
                    setPlayerId(1);
                    setMessage("'X':  Player " + getPlayerId());
                }
                view.update(x, y, board[x][y], getMessage());
            }
        }
    }

    public boolean isWinner(int x, int y) {
        int countRow = 0;
        int countCol = 0;
        int countLDiag = 0;
        int countRDiag = 0;
        char symbol;
        if (getPlayerId() % 2 != 0)
            symbol = 'X';
        else
            symbol = 'O';

        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == symbol) {
                countRow++;
            }
            if (board[i][y] == symbol) {
                countCol++;
            }
            if (board[i][i] == symbol) {
                countRDiag++;
            }
            if (board[board.length - 1 - i][i] == symbol) {
                countLDiag++;
            }
        }

        return countCol == board.length || countRow == board.length
                || countLDiag == board.length || countRDiag == board.length;
    }

    public void resetModel() {
        movesCount = 9;
        setPlayerId(1);
        setMessage("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '\0';
            }
        }
        view.resetGame();
    }
}

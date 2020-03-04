package com.alevel.java.nix.tictactoemvc;

import com.alevel.java.nix.tictactoemvc.controller.Controller;
import com.alevel.java.nix.tictactoemvc.model.Model;
import com.alevel.java.nix.tictactoemvc.view.View;

public class TicTacToe {
    public static void main(String[] args) {

        Controller c = new Controller();
        View v = new View();
        Model m = new Model();

        m.registerView(v);
        c.setModel(m);
        v.setActionListener(c);
    }
}

package com.alevel.java.nix.tictactoemvc.controller;

import com.alevel.java.nix.tictactoemvc.model.Model;

import java.util.ArrayList;

public class Controller {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setRequest(ArrayList<Integer> position) {
        model.playMove(position.get(0), position.get(1));
    }

    public void setRequest() {
        model.resetModel();
    }
}

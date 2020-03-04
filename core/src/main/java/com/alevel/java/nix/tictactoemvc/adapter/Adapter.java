package com.alevel.java.nix.tictactoemvc.adapter;

import com.alevel.java.nix.tictactoemvc.controller.Controller;
import com.alevel.java.nix.tictactoemvc.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Adapter implements ActionListener {

    private Controller controller;
    private View view;

    public Adapter(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        if (view.isReset(e)) {
            controller.setRequest();
        } else {
            ArrayList<Integer> position = view.getPosition(e);
            controller.setRequest(position);
        }
    }
}

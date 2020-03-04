package com.alevel.java.nix.tictactoemvc.controller;

import com.alevel.java.nix.tictactoemvc.model.Model;
import com.alevel.java.nix.tictactoemvc.view.View;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    public void testGameState() {
        Controller controller = new Controller();
        Model model = new Model();
        View view = new View();
        model.registerView(view);
        controller.setModel(model);

        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(1);
        pos.add(1);

        controller.setRequest(pos);

        assertEquals('X', model.getBoard()[1][1]);
    }
}
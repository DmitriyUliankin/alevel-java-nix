package com.alevel.java.nix.tictactoemvc.view;

import com.alevel.java.nix.tictactoemvc.controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest {

    @Test
    public void testGameState() {
        Controller controller = new Controller();
        View view = new View();
        view.setActionListener(controller);

        view.update(1, 1, 'x', "'O':  Player 2");
        assertEquals("x", view.getButtonText(1, 1));
    }
}
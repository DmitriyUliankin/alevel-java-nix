package com.alevel.java.nix.tictactoemvc.model;

import com.alevel.java.nix.tictactoemvc.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

    @Test
    public void testGameState() {
        View view = new View();
        Model model = new Model();
        model.registerView(view);
        model.playMove(1, 1);

        assertEquals(8, model.getMovesCount());
        assertEquals('X', model.getBoard()[1][1]);

        model.resetModel();
        assertEquals(9, model.getMovesCount());
    }
}
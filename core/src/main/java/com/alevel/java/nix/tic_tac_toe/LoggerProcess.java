package com.alevel.java.nix.tic_tac_toe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProcess implements Display {

    private static final Logger log = LoggerFactory.getLogger(LoggerProcess.class);

    @Override
    public void drawCanvas() {
        log.info("started drawing canvas");
    }

    @Override
    public boolean isDraw() {
        log.info("is draw");
        return true;
    }
}

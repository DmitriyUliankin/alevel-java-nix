package com.alevel.java.nix.retry;

@FunctionalInterface
public interface Block {

    void run() throws Exception;

}

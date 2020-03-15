package com.alevel.java.nix.retry;

@FunctionalInterface
public interface Block<T> {

    T run() throws Exception;

}

package com.alevel.java.nix.reflection;

public class AppProperty {

    @PropertyKey(name = "annotation")
    public String name;

    @PropertyKey(limit = 10)
    public int limit;

    @PropertyKey(author = "author")
    public String author;

}

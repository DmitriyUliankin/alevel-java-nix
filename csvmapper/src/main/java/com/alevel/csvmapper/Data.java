package com.alevel.csvmapper;

import com.alevel.csvmapper.table.Key;

public class Data {

    @Key("name")
    private String name;

    @Key("age")
    private int age;

    @Key("city")
    private String city;

}

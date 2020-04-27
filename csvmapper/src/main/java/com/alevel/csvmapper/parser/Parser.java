package com.alevel.csvmapper.parser;

import com.alevel.csvmapper.table.Table;

public interface Parser<T> {

    Table parse(T target);

}

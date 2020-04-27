package com.alevel.csvmapper.mapper;

import com.alevel.csvmapper.table.Table;

import java.util.List;

public interface Mapper {

    <T> List<T> map(Table table, Class<T> classType);

}

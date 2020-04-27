package com.alevel.csvmapper.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Row {

    private final List<Cell> cells;

    public Row(List<String> cells) {
        this.cells = new ArrayList<>();
        addCell(cells);
    }

    public int size() {
        return cells.size();
    }

    public Cell getCell(int index) {
        return cells.get(index);
    }

    public static Row parseLine(String csvLine) {
        return new Row(Arrays.asList(csvLine.split(",")));
    }

    private void addCell(List<String> cells) {
        for (var cell : cells) {
            this.cells.add(new Cell(cell));
        }
    }

}

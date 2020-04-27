package com.alevel.csvmapper.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Table {

    private final List<Row> rows;

    private final Map<String, Integer> header;

    public Table(Row header) {
        var columnCount = header.size();
        this.header = new HashMap<>();
        addRow(header, columnCount);
        this.rows = new ArrayList<>();
    }

    public List<Row> getRows() {
        return rows;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public Integer getColumn(String column) {
        return header.get(column);
    }

    private void addRow(Row header, int columnCount) {
        for (int i = 0; i < columnCount; i++) {
            this.header.put(header.getCell(i).getValue(), i);
        }
    }
}

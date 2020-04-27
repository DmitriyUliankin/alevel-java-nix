package com.alevel.csvmapper.mapper;

import com.alevel.csvmapper.table.Key;
import com.alevel.csvmapper.table.Row;
import com.alevel.csvmapper.table.Table;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapperImplementation implements Mapper {

    @Override
    public <T> List<T> map(Table table, Class<T> c) {

        try {
            Field[] fields = c.getFields();

            Constructor<T> constructor = c.getConstructor();

            var map = new HashMap<String, Field>();

            for (var field : fields) {
                var key = field.getAnnotation(Key.class);
                if (field.trySetAccessible()) {
                    map.put(key.value(), field);
                }
            }

            List<Row> rows = table.getRows();

            List<T> output = new ArrayList<>();

            int counter = 0;
            int rowsSize = rows.size();
            while (counter < rowsSize) {
                Row row = rows.get(counter);
                T object = constructor.newInstance();
                for (Map.Entry<String, Field> entry : map.entrySet()) {
                    var name = entry.getKey();
                    var field = entry.getValue();
                    var cell = row.getCell(table.getColumn(name));
                    Class<?> classField = field.getType();
                    if (classField.equals(String.class)) {
                        field.set(object, cell.getValue());
                    }
                    if (classField.equals(Integer.class)) {
                        field.setInt(object, Integer.parseInt(cell.getValue()));
                    }
                    if (classField.equals(Long.class)) {
                        field.setLong(object, Long.parseLong(cell.getValue()));
                    }
                    if (classField.equals(Double.class)) {
                        field.setDouble(object, Double.parseDouble(cell.getValue()));
                    }
                    if (classField.equals(Boolean.class)) {
                        field.setBoolean(object, Boolean.parseBoolean(cell.getValue()));
                    }
                }
                output.add(object);
                counter++;
            }
            return output;

        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}

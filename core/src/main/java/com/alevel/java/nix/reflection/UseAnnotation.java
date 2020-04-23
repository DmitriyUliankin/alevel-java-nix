package com.alevel.java.nix.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

public class UseAnnotation {

    private static final String separator = System.lineSeparator();

    private static final Properties properties = new Properties();

    private static final String fileName =
            "/Users/mcmisle/Documents/A-Level/Maven/core/src/main/java/com/alevel/java/nix/reflection/app.properties";

    private static Object getPropertyFromFile(Field fieldName) {
        try {
            var fileInputStream = new FileInputStream(fileName);
            properties.load(fileInputStream);
            if (fieldName.getType() == String.class) {
                return String.valueOf(properties.getProperty(fieldName.getName()));
            }
            if (fieldName.getType() == int.class) {
                return Integer.parseInt(properties.getProperty(fieldName.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static void check(Object object, Class<?> classOfInstance) {

        var fields = Arrays.asList(classOfInstance.getDeclaredFields());

        fields.stream()
                .filter(i -> i.isAnnotationPresent(PropertyKey.class))
                .forEach(i -> {
                    try {
                        classOfInstance.getField(i.getName()).set(object, getPropertyFromFile(i));
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void main(String[] args) {
        var instance = new AppProperty();
        Class<? extends AppProperty> classOfInstance = instance.getClass();

        check(instance, classOfInstance);

        System.out.println("name: " + instance.name
                + separator
                + "limit: " + instance.limit
                + separator
                + "author: " + instance.author);
    }

}

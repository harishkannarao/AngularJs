package com.harishkannarao.angularjs.restapi.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class PropertiesReference {
    public static final Properties MAVEN_PROPERTIES = loadPropertiesFromResources("maven.properties");

    public static Properties loadPropertiesFromResources(String propertyFile) {
        Properties properties = new Properties();
        InputStream inputStream = PropertiesReference.class.getClassLoader().getResourceAsStream(propertyFile);
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static Properties loadPropertiesFromPath(String propertyFile) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(propertyFile), StandardOpenOption.READ);
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}

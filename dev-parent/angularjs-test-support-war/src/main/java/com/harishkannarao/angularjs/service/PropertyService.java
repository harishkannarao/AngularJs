package com.harishkannarao.angularjs.service;

import javax.ejb.Stateless;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Stateless
public class PropertyService {

    public static final String ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES = "angularjs-rest-settings-through-module.properties";

    public void addOrUpdateModuleProperty(String key, String value) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertyService.class.getClassLoader().getResourceAsStream(ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        properties.setProperty(key, value);

        Path propertyFilepath;
        try {
            propertyFilepath = Paths.get(this.getClass().getClassLoader().getResource(ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream outputStream = Files.newOutputStream(propertyFilepath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

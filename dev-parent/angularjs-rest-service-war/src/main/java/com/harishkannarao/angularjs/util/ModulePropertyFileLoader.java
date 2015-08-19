package com.harishkannarao.angularjs.util;


import com.harishkannarao.angularjs.listener.ModulePropertyFileListener;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@ApplicationScoped
public class ModulePropertyFileLoader {

    public static final String ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES = "angularjs-rest-settings-through-module.properties";
    private static String sampleString;
    private static List<String> listOfString;
    private static Long sampleLong;
    private static Boolean enablePropertyChangeListener;

    @PostConstruct
    private void initLoader() {
        loadProperties();
        if (enablePropertyChangeListener) {
            new Thread(new ModulePropertyFileListener()).start();
        }
    }

    public static void loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = ModulePropertyFileLoader.class.getClassLoader().getResourceAsStream(ANGULARJS_REST_SETTINGS_THROUGH_MODULE_PROPERTIES)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sampleString = properties.getProperty("sampleString");
        listOfString = Arrays.asList(properties.getProperty("sampleStringArray").split(",")).stream().map(String::trim).collect(Collectors.toList());
        sampleLong = Long.valueOf(properties.getProperty("sampleLong"));
        enablePropertyChangeListener = Boolean.valueOf(properties.getProperty("enablePropertyChangeListener"));
    }

    public String getSampleString() {
        return sampleString;
    }

    public List<String> getListOfString() {
        return listOfString;
    }

    public Long getSampleLong() {
        return sampleLong;
    }

    public Boolean getEnablePropertyChangeListener() {
        return enablePropertyChangeListener;
    }
}

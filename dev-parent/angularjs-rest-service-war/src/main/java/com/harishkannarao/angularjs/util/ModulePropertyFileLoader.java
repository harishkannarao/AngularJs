package com.harishkannarao.angularjs.util;


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

    private String sampleString;
    private List<String> listOfString;
    private Long sampleLong;

    @PostConstruct
    public void loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("angularjs-rest-settings-through-module.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sampleString = properties.getProperty("sampleString");
        listOfString = Arrays.asList(properties.getProperty("sampleStringArray").split(",")).stream().map(String::trim).collect(Collectors.toList());
        sampleLong = Long.valueOf(properties.getProperty("sampleLong"));
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
}

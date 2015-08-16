package com.harishkannarao.angularjs.webapp.util;

public class StringUtils {

    public static String convertToUnicodeString(String inputString) {
        StringBuilder resultBuilder = new StringBuilder();

        for (char character :inputString.toCharArray()){
            resultBuilder.append(String.format("\\u%04x", (int) character));
        }
        return resultBuilder.toString();
    }
}

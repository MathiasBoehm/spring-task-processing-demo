package de.struktuhr.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestHelper {

    public static void printJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(s);
        }
        catch (JsonProcessingException e) {
           throw new RuntimeException(e);
        }
    }
}

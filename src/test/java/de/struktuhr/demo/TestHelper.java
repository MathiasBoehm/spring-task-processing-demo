package de.struktuhr.demo;


import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

public class TestHelper {

    public static void printJson(Object obj) {
        ObjectMapper mapper = new JsonMapper();
        try {
            String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(s);
        }
        catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
}

package vn.binhhq.fun.service.test_override;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Son extends Father{



    @Override
    public Long getId() {
        System.out.println("Son");
        return super.getId();
    }

    public static void main(String [] agrs){
        ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        String json = "{\"id\" :  1, \"name\": \"binh\"}";
        try {
            JsonNode jsonNode = mapper.readTree(json);
            String name = jsonNode.get("name").asText();
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Son s = new Son();
        s.setId(1L);
        s.getId();
    }
}

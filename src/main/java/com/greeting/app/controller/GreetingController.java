package com.greeting.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    // mapes into object
    private final ObjectMapper objectMapper = new ObjectMapper();

    // get method to return json
    @GetMapping
    public String getGreet() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello from get method");
        return objectMapper.writeValueAsString(map); // converts into json
    }

    // post method to return json
    @PostMapping
    public String postGreet() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello from post method");
        return objectMapper.writeValueAsString(map);
    }

    // put method to return json
    @PutMapping
    public String putGreet() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello from put method");
        return objectMapper.writeValueAsString(map);
    }

    // delete method to return json
    @DeleteMapping
    public String deleteGreet() throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello from delete method");
        return objectMapper.writeValueAsString(map);
    }
}

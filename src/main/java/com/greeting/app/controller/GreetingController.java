package com.greeting.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greeting.app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode objectNode;

    GreetingController(){
        objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "default_value");
    }

    @Autowired
    GreetingService greetingService;
    //Get Mapping
    @GetMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> sayHello(){
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }

    //Post Mapping
    @PostMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> postHello(@RequestBody Map<String, String> newData) {
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }

    //Put Mapping
    @PutMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> putHello(@RequestBody Map<String,String> newData){
        objectNode.put("name", newData.get("name"));
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }

    //Delete Mapping
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> deleteHello(@RequestBody Map<String,String> newData){
        objectNode.remove("name");
        return ResponseEntity.ok(greetingService.myservice(objectNode));
    }
}
package com.greeting.app.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greeting.app.dto.GreetingDTO;
import com.greeting.app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    //Get Mapping
    @GetMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> sayHello(@RequestParam Long id) {
        return ResponseEntity.ok(greetingService.getmyservice(id));
    }

    //Get All
    @GetMapping(value = "/all",produces = "application/json")
    public ResponseEntity<ArrayNode> helloAll(){
        return ResponseEntity.ok(greetingService.getAllservice());
    }

    //Post Mapping
    @PostMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> postHello(@RequestBody GreetingDTO newData) {
        return ResponseEntity.ok(greetingService.setmyservice(newData));
    }

    //Put Mapping
    @PutMapping(produces = "application/json")
    public ResponseEntity<ObjectNode> putHello(@RequestBody GreetingDTO newData) {
        return ResponseEntity.ok(greetingService.editmyservice(newData));
    }

    //Delete Mapping
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<String> deleteHello(@RequestBody GreetingDTO newData){
        return ResponseEntity.ok(greetingService.deletemyservice(newData));
    }
}
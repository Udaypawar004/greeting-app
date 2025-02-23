package com.greeting.app.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class GreetingService {
    public ObjectNode myservice(ObjectNode objectNode){
        return objectNode.put("used_service","myservice");
    }
}
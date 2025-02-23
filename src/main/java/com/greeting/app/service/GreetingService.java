package com.greeting.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greeting.app.dto.GreetingDTO;
import com.greeting.app.entity.Greeting;
import com.greeting.app.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    //the { payload -> GreetingDTO } is Mapped using Model.Mapper and preserved to greetingrepository
    @Autowired
    private GreetingRepository greetingRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ObjectNode setmyservice(GreetingDTO greetingDTO) {
        Greeting greeting = modelMapper.map(greetingDTO, Greeting.class);
        Greeting savedGreeting = greetingRepository.save(greeting);
        return createGreetingObjectNode(savedGreeting)
                .put("used_service", "myservice");
    }

    public ArrayNode getAllservice() {
        List<Greeting> greetingsFromRepo = greetingRepository.findAll();
        ArrayNode arrayNodeForAllMSgs = objectMapper.createArrayNode();
        for (Greeting greeting : greetingsFromRepo) {
            arrayNodeForAllMSgs.add(createGreetingObjectNode(greeting));
        }
        return arrayNodeForAllMSgs;
    }

    public String deletemyservice(GreetingDTO greetingDTO){
        Greeting greeting = modelMapper.map(greetingDTO, Greeting.class);
        greetingRepository.deleteById(greeting.getId());//TODO it throws exception
        return "removed ID";
    }

    public ObjectNode getmyservice(Long id) {
        Optional<Greeting> savedGreeting = greetingRepository.findById(id);
        if (savedGreeting.isPresent()) {
            return createGreetingObjectNode(savedGreeting.get());
        } else {
            ObjectNode errorNode = objectMapper.createObjectNode();
            errorNode.put("error", "Greeting not found for id: " + id);
            return errorNode;
        }
    }

    public ObjectNode editmyservice(GreetingDTO greetingDTO){
        Greeting greeting = modelMapper.map(greetingDTO,Greeting.class);
        return createGreetingObjectNode(greetingRepository.save(greeting));
    }

    private ObjectNode createGreetingObjectNode(Greeting greeting) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("id", greeting.getId());
        objectNode.put("fname", greeting.getFname());
        objectNode.put("lname", greeting.getLname());
        objectNode.put("message", greeting.getMessage());
        return objectNode;
    }
}
package com.learning.spring.app.controllers;

import com.learning.spring.app.models.MessageRequest;
import com.learning.spring.app.models.MessageResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Message {

    private Map<Integer, String> messagesList = new HashMap<>();
    private int currentId = 0;
    @PostMapping("/message")
    public MessageResponse CreateMessage(@RequestBody MessageRequest request) {
        String message = request.getMessage();
        if (message == null || message.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message cannot be empty or null");
        }
        messagesList.put(currentId, message.trim());
        String response = "Created Message with ID: " + currentId;
        currentId++;
        return new MessageResponse(response);
    }

    @GetMapping("/message")
    public Object ShowMessage(@RequestParam(required = false) Integer id) {
        if (id == null) {
            return messagesList.values();
        } else {
            if(id <= 0 || id != Math.floor(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID param must be an int");
            }
            String response = messagesList.get(id);
            if (response == null || response.trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
            }
            return new MessageResponse(response);
        }
    }

    @PutMapping("/message")
    public MessageResponse UpdateMessage(@RequestParam Integer id, @RequestBody MessageRequest request) {
        String message = request.getMessage();
        messagesList.put(currentId, message);
        String response = "Message Changed with ID: " + id;
        return new MessageResponse(response);
    }

    @DeleteMapping("/message")
    public MessageResponse DeleteMessage(@RequestParam Integer id) {
        messagesList.remove(id);
        String response = "Message Deleted with ID:" + id;
        return new MessageResponse(response);
    }
}

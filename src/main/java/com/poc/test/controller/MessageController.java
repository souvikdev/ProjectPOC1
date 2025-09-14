package com.poc.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.test.service.SQSSenderService;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final SQSSenderService sender;

    public MessageController(SQSSenderService sender) { 
    	this.sender = sender; 
    }

    @PostMapping
    public String post(@RequestBody String payload) {
        return sender.send(payload); // returns messageId
    }
}
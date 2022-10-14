package com.usa.mtic.proyectog_0.controller;

import com.usa.mtic.proyectog_0.models.Message;
import com.usa.mtic.proyectog_0.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("save")
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }
}

package com.usa.mtic.proyectog_0.controller;

import com.usa.mtic.proyectog_0.models.Client;
import com.usa.mtic.proyectog_0.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client l){
        return clientService.save(l);
    }
}

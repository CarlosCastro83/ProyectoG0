package com.usa.mtic.proyectog_0.controller;

import com.usa.mtic.proyectog_0.models.Computer;
import com.usa.mtic.proyectog_0.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Computer")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("/all")
    public List<Computer> getAll(){
        return computerService.getAll();
    }

    @PostMapping("/save")
    public Computer save(@RequestBody Computer c){
        return computerService.save(c);
    }
}

package com.usa.mtic.proyectog_0.controller;

import com.usa.mtic.proyectog_0.models.Reservation;
import com.usa.mtic.proyectog_0.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }
}

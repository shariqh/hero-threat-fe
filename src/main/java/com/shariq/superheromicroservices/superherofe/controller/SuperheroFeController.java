package com.shariq.superheromicroservices.superherofe.controller;

import com.shariq.superheromicroservices.superherofe.model.Villain;
import com.shariq.superheromicroservices.superherofe.service.SuperheroFeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superhero")
public class SuperheroFeController {

    @Autowired
    private SuperheroFeService superheroFeService;

    @PostMapping
    public ResponseEntity<Villain> createVillain(Villain newVillain) {

        return ResponseEntity.ok(superheroFeService.createVillain(newVillain));
    }
}

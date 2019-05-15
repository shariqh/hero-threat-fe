package com.shariq.superheromicroservices.superherofe.controller;

import com.shariq.superheromicroservices.superherofe.model.Villain;
import com.shariq.superheromicroservices.superherofe.service.SuperheroFeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superhero")
public class SuperheroFeController {

    private final SuperheroFeService superheroFeService;

    @Autowired
    public SuperheroFeController(SuperheroFeService superheroFeService) {
        this.superheroFeService = superheroFeService;
    }

    @PostMapping("/createVillain")
    public ResponseEntity<Villain> createVillain(@RequestBody Villain newVillain) {
        return ResponseEntity.ok(superheroFeService.createVillain(newVillain));
    }
}

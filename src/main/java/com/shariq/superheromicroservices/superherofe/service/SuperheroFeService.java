package com.shariq.superheromicroservices.superherofe.service;

import com.shariq.superheromicroservices.superherofe.client.SuperheroClient;
import com.shariq.superheromicroservices.superherofe.model.Villain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperheroFeService {

    private final SuperheroClient superheroClient;

    @Autowired
    public SuperheroFeService(SuperheroClient superheroClient) {
        this.superheroClient = superheroClient;
    }

    public Villain createVillain(Villain newVillain) {
        return superheroClient.createVillain(newVillain);
    }
}

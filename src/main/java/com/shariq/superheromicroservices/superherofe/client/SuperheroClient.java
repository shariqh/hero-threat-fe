package com.shariq.superheromicroservices.superherofe.client;

import com.shariq.superheromicroservices.superherofe.model.Villain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("villains")
public interface SuperheroClient {

    @PostMapping("/villains")
    Villain createVillain(Villain newVillain);
}

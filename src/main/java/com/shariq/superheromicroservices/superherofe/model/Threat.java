package com.shariq.superheromicroservices.superherofe.model;

import lombok.Data;

@Data
public class Threat {

    private Long id;
    private String name;
//    private Hero hero;
//    private Villain villain;

    public Threat(String name) {
        this.name = name;
    }

//    public Threat(String name, Villain villain) {
//        this.name = name;
//        this.villain = villain;
//    }

}

package com.shariq.superheromicroservices.superherofe.model;

import lombok.Data;

import java.util.List;

@Data
public class Villain {

    private Long id;
    private String name;
//    private List<Threat> threats;

    public Villain(String name) {
        this.name = name;
    }
}

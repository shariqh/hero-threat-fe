package com.shariq.superheromicroservices.superherofe.service;

import com.shariq.superheromicroservices.superherofe.client.SuperheroClient;
import com.shariq.superheromicroservices.superherofe.model.Villain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SuperheroFeServiceTest {

    @Mock
    private SuperheroClient superheroClient;

    @InjectMocks
    private SuperheroFeService superheroFeService;

    @Test
    public void createVillain() {
        Villain newVillain = new Villain("Joker");

        when(superheroClient.createVillain(newVillain)).thenReturn(newVillain);

        Villain result = superheroFeService.createVillain(newVillain);

        verify(superheroClient).createVillain(newVillain);
        assertThat("Villain was not created", result, equalTo(newVillain));
    }
}
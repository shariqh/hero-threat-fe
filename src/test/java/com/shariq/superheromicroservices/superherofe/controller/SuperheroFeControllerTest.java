package com.shariq.superheromicroservices.superherofe.controller;

import com.shariq.superheromicroservices.superherofe.model.Villain;
import com.shariq.superheromicroservices.superherofe.service.SuperheroFeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SuperheroFeControllerTest {

    @Mock
    private SuperheroFeService superheroFeService;

    @InjectMocks
    private SuperheroFeController superheroFeController;

    @Test
    public void createVillain_VillainDoesNotExist_createsVillain() {
        Villain newVillain = new Villain("Joker");

        when(superheroFeService.createVillain(newVillain)).thenReturn(newVillain);

        ResponseEntity<Villain> result = superheroFeController.createVillain(newVillain);

        verify(superheroFeService).createVillain(newVillain);
        assertThat("Villain was not created", result.getBody(), equalTo(newVillain));
    }


}

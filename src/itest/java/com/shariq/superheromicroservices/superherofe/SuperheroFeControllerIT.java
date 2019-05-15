package com.shariq.superheromicroservices.superherofe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shariq.superheromicroservices.superherofe.controller.SuperheroFeController;
import com.shariq.superheromicroservices.superherofe.model.Villain;
import com.shariq.superheromicroservices.superherofe.service.SuperheroFeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ActiveProfiles("test")
@WebMvcTest(SuperheroFeController.class)
public class SuperheroFeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SuperheroFeService superheroFeService;

    @Before
    public void setup() {
        Villain validVillain = new Villain("validVillain");
    }

    @Test
    public void createVillain_mockMvcCallsEndpoint_returnsVillain() throws Exception {
        Villain validVillain = new Villain("validVillain");

        when(superheroFeService.createVillain(validVillain)).thenReturn(validVillain);

        mockMvc.perform(post("/superhero/createVillain")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(validVillain)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(validVillain)))
                .andReturn();
    }
}

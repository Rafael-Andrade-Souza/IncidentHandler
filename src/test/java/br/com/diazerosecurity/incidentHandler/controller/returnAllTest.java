package br.com.diazerosecurity.incidentHandler.controller;

import br.com.diazerosecurity.incidentHandler.entity.Incident;
import br.com.diazerosecurity.incidentHandler.services.IncidentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


public class returnAllTest {
    @Mock
    private IncidentService incidentService;
    private IncidentController incidentController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        incidentController = new IncidentController(incidentService);
    }

    @Test
    public void testFindAll(){
        Incident incident1 = new Incident();
        incident1.setId(1L);
        Incident incident2 = new Incident();
        incident2.setId(2L);

        List<Incident> incidents = Arrays.asList(incident1,incident2);
        when(incidentService.findAll()).thenReturn(incidents);

        ResponseEntity<List<Incident>> response =
                incidentController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(incidents, response.getBody());
    }
}

package br.com.diazerosecurity.incidentHandler.controller;

import br.com.diazerosecurity.incidentHandler.entity.Incident;
import br.com.diazerosecurity.incidentHandler.services.IncidentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class createIncidentTest {
    @Mock
    private IncidentService incidentService;
    private IncidentController incidentController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        incidentController = new IncidentController(incidentService);
    }

    @Test
    public void testCreateIncident(){
        Incident incident = new Incident();
        incident.setId(1L);
        when(incidentService.save(incident)).thenReturn(incident);

        ResponseEntity<Incident> response =
                incidentController.createIncident(incident);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(incident,response.getBody());
    }
}

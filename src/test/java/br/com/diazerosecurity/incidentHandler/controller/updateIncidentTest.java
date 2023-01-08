package br.com.diazerosecurity.incidentHandler.controller;

import br.com.diazerosecurity.incidentHandler.entity.Incident;
import br.com.diazerosecurity.incidentHandler.services.IncidentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class updateIncidentTest {
    @Mock
    private IncidentService incidentService;
    private IncidentController incidentController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        incidentController = new IncidentController(incidentService);
    }
    @Test
    public void testUpdateIncident(){
        Long id = 1L;
        Incident incident = new Incident();
        incident.setId(id);
        when(incidentService.findById(id)).thenReturn(Optional.of(incident));
        when(incidentService.save(incident)).thenReturn(incident);
        ResponseEntity<Incident> response =
                incidentController.updateIncident(id, incident);
                assertEquals(HttpStatus.OK, response.getStatusCode());
                assertEquals(incident, response.getBody());
        when(incidentService.findById(id)).thenReturn(Optional.empty());
        response = incidentController.updateIncident(id, incident);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

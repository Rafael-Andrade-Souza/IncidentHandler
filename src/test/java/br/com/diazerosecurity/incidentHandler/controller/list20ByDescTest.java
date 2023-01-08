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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class list20ByDescTest {
    @Mock
    private IncidentService incidentService;

    private IncidentController incidentController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        incidentController = new IncidentController(incidentService);
    }

    @Test
    public void testFindTop20() {
        Incident incident1 = new Incident();
        incident1.setId(1L);
        Incident incident2 = new Incident();
        incident2.setId(2L);
        List<Incident> incidents = Arrays.asList(incident1, incident2);
        when(incidentService.findTop20ByOrderByCreatedAtDesc()).thenReturn(incidents);

        ResponseEntity<List<Incident>> response = incidentController.findTop20();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(incidents, response.getBody());
    }
}


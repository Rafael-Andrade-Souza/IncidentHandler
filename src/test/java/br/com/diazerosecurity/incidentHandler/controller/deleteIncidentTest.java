package br.com.diazerosecurity.incidentHandler.controller;

import br.com.diazerosecurity.incidentHandler.services.IncidentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class deleteIncidentTest {

    @Mock
    private IncidentService incidentService;
    private IncidentController incidentController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        incidentController = new IncidentController(incidentService);
    }

    @Test
    public void testDeleteIncident(){
        Long id = 1L;
        incidentController.deleteIncident(id);
        verify(incidentService).deleteById(id);
    }
}

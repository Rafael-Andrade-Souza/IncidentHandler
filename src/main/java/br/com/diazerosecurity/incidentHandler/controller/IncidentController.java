package br.com.diazerosecurity.incidentHandler.controller;

import br.com.diazerosecurity.incidentHandler.entity.Incident;
import br.com.diazerosecurity.incidentHandler.services.IncidentService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {

        this.incidentService = incidentService;
    }
    // Adicionando funcionalidade exigidas no desafio.
    // Cadastrar incidentes
    @PostMapping
    @ApiOperation("Crie novo incidente")
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident)
    {
        Incident savedIncident = incidentService.save(incident);
        return ResponseEntity.ok(savedIncident);
    }

    // Atualizar incidentes
    @PutMapping("/{id}")
    @ApiOperation("Atualize incidentes existentes")

    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        Optional<Incident> existingIncident = incidentService.findById(id);
        if (existingIncident.isPresent()) {
            Incident updatedIncident = incidentService.save(incident);
            return ResponseEntity.ok(updatedIncident);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar incidentes
    @DeleteMapping("/{id}")
    @ApiOperation("Delete Incidentes")

    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Listar Todos os incidentes.
    @GetMapping("/all")
    @ApiOperation("Liste todos os incidentes")

    public ResponseEntity<List<Incident>> findAll() {
        return ResponseEntity.ok(incidentService.findAll());
    }

    // Listar incidente por ID
    @GetMapping("/{id}")
    @ApiOperation("Liste incidente através do UUID")

    public ResponseEntity<Incident> findById(@PathVariable Long id) {
        Optional<Incident> incident = incidentService.findById(id);
        if (incident.isPresent()) {
            return ResponseEntity.ok(incident.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Listar os últimos 20 incidentes por ordem decrescente.
    @GetMapping("/latest")
    @ApiOperation("Listar últimos 20 incidentes por ordem decrescente")

    public ResponseEntity<List<Incident>> findTop20() {
        return ResponseEntity.ok(incidentService.findTop20ByOrderByCreatedAtDesc());
    }

}
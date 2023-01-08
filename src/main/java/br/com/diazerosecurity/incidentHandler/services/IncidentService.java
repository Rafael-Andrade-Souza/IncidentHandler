package br.com.diazerosecurity.incidentHandler.services;
import br.com.diazerosecurity.incidentHandler.entity.Incident;
import java.util.List;
import java.util.Optional;

public interface IncidentService {
    List<Incident> findAll();
    List<Incident> findTop20ByOrderByCreatedAtDesc();
    Optional<Incident> findById(Long id);
    Incident save(Incident incident);
    void deleteById(Long id);
}

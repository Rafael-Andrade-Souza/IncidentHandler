package br.com.diazerosecurity.incidentHandler.repository;
import br.com.diazerosecurity.incidentHandler.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findTop20ByOrderByCreatedAtDesc();

}

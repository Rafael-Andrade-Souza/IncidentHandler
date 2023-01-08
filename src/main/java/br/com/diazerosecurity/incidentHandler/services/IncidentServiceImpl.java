package br.com.diazerosecurity.incidentHandler.services;

import br.com.diazerosecurity.incidentHandler.entity.Incident;
import br.com.diazerosecurity.incidentHandler.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService{
    private final IncidentRepository incidentRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository){
        this.incidentRepository = incidentRepository;
    }
    @Override
    public List<Incident> findAll(){
        return incidentRepository.findAll();
    }

    @Override
    public List<Incident> findTop20ByOrderByCreatedAtDesc(){
        return incidentRepository.findTop20ByOrderByCreatedAtDesc();
    }

    @Override
    public Optional<Incident> findById(Long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public void deleteById(Long id) {
        incidentRepository.deleteById(id);
    }
}

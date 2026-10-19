package tn.esprit.autolocapi.service;

import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.VehiculeRepository;
import java.util.List;

@Service
public class VehiculeService {
    private final VehiculeRepository repo;

    public VehiculeService(VehiculeRepository repo) { this.repo = repo; }

    public List<Vehicule> lister() { return repo.findAll(); }
    public Vehicule obtenir(Long id) { return repo.findById(id).orElse(null); }
    public Vehicule enregistrer(Vehicule v) { return repo.save(v); }
    public void supprimer(Long id) { repo.deleteById(id); }
}
package tn.esprit.autolocapi.service;

import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.repository.AgenceRepository;
import java.util.List;

@Service
public class AgenceService {
    private final AgenceRepository repo;

    public AgenceService(AgenceRepository repo) { this.repo = repo; }

    public List<Agence> lister() { return repo.findAll(); }
    public Agence enregistrer(Agence a) { return repo.save(a); }
}
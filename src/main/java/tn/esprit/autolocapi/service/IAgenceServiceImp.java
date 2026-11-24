package tn.esprit.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class IAgenceServiceImp implements IAgenceService{
    /* @autowired*/

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }


    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> getAllAgence() {
        return agenceRepository.findAll();
    }

    @Override
    public void supprimerAgenceById(Long id) {
        agenceRepository.deleteById(id);

    }

    @Override
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules = agence.getVehicules();
        Agence a = agenceRepository.save(agence);
        for (Vehicule v : vehicules) {
            v.setAgence(a);
            vehiculeRepository.save(v);
        }
        return a;
    }

}

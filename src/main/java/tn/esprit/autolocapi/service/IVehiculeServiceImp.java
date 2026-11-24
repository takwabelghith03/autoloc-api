package tn.esprit.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.EquipementRepository;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class IVehiculeServiceImp implements IVehiculeService{
    /* @autowired*/

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }


    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> getAllVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void supprimerVehiculeById(Long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule).get();
        Equipement e = equipementRepository.findById(idEquipement).get();
        v.getEquipements().add(e);
        return vehiculeRepository.save(v);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepository.findById(idVehicule).get();
        Equipement e = equipementRepository.findById(idEquipement).get();
        v.getEquipements().remove(e);
        return vehiculeRepository.save(v);
    }
}

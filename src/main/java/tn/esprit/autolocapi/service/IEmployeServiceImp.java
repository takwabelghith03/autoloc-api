package tn.esprit.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class IEmployeServiceImp implements IEmployeService{
    /* @autowired*/

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }


    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public void supprimerEmployeById(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe desaffecterEmploye(Long idEmploye){
        Employe e = employeRepository.findById(idEmploye).get();
        e.setAgence(null);
        return employeRepository.save(e);
    }

    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence){
        Employe e = employeRepository.findById(idEmploye).get();
        Agence a = agenceRepository.findById(idAgence).get();
        e.setAgence(a);
        return employeRepository.save(e);
    }
}
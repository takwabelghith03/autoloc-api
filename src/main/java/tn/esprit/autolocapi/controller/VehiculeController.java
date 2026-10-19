package tn.esprit.autolocapi.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.service.VehiculeService;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final VehiculeService service;

    public VehiculeController(VehiculeService service) { this.service = service; }

    @GetMapping
    public List<Vehicule> lister() { return service.lister(); }

    @GetMapping("/{id}")
    public Vehicule obtenir(@PathVariable Long id) { return service.obtenir(id); }

    @PostMapping
    public Vehicule ajouter(@RequestBody Vehicule v) { return service.enregistrer(v); }

    @PutMapping
    public Vehicule modifier(@RequestBody Vehicule v) { return service.enregistrer(v); }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) { service.supprimer(id); }
}
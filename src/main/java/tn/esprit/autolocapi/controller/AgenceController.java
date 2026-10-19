package tn.esprit.autolocapi.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.service.AgenceService;
import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    private final AgenceService service;

    public AgenceController(AgenceService service) { this.service = service; }

    @GetMapping
    public List<Agence> lister() { return service.lister(); }

    @PostMapping
    public Agence ajouter(@RequestBody Agence a) { return service.enregistrer(a); }
}
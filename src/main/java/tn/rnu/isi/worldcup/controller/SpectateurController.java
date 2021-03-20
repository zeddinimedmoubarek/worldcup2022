package tn.rnu.isi.worldcup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.rnu.isi.worldcup.entities.Spectateur;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.SpectateurRepository;



@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class SpectateurController {
	@Autowired
    private SpectateurRepository spectateurRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/spectateurs")
    public List<Spectateur> getAllSpectateurs() {
        return spectateurRepository.findAll();
    }
    
    @PostMapping("/spectateurs")
    public Spectateur createSpectateur(@Valid @RequestBody Spectateur spectateur) {
        return spectateurRepository.save(spectateur);
    }

    @GetMapping("/spectateurs/{id}")
    public ResponseEntity<Spectateur> getSpectateurById(
            @PathVariable(value = "id") Long spectateurId)
            throws ResourceNotFoundException {
        Spectateur spectateur = spectateurRepository.findById(spectateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Spectateur introuvable avec le code = " + spectateurId));
        return ResponseEntity.ok().body(spectateur);
    }

    @PutMapping("/spectateurs/{id}")
    public ResponseEntity<Spectateur> updateSpectateur(
            @PathVariable(value = "id") Long spectateurId,@Valid @RequestBody Spectateur spectateurDetails) throws ResourceNotFoundException {
        Spectateur spectateur = spectateurRepository.findById(spectateurId).orElseThrow(() -> new ResourceNotFoundException("Spectateur introuvable avec le code = " + spectateurId));
        spectateur.setNom(spectateurDetails.getNom());
        spectateur.setPrenom(spectateurDetails.getPrenom());
        spectateur.setImage_spec(spectateurDetails.getImage_spec());

        final Spectateur updatedSpectateur = spectateurRepository.save(spectateur);
        return ResponseEntity.ok(updatedSpectateur);
    }

    @DeleteMapping("/spectateurs/{id}")
    public Map<String, Boolean> deleteSpectateur(
            @PathVariable(value = "id") Long spectateurId)
            throws ResourceNotFoundException {
        Spectateur spectateur = spectateurRepository.findById(spectateurId).orElseThrow(() -> new ResourceNotFoundException("Spectateur introuvable avec le code = " + spectateurId));

        spectateurRepository.delete(spectateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
}

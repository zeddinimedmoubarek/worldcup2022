package tn.rnu.isi.worldcup.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Arbitre;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.ArbitreRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArbitreController {
	@Autowired
    private ArbitreRepository arbitreRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/arbitres")
    public List<Arbitre> getAllArbitres() {
        return arbitreRepository.findAll();
    }
    
    @PostMapping("/arbitres")
    public Arbitre createArbitre(@Valid @RequestBody Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    @GetMapping("/arbitres/{id}")
    public ResponseEntity<Arbitre> getArbitreById(
            @PathVariable(value = "id") Long arbitreId)
            throws ResourceNotFoundException {
        Arbitre arbitre = arbitreRepository.findById(arbitreId)
                .orElseThrow(() -> new ResourceNotFoundException("Arbitre introuvable avec le code = " + arbitreId));
        return ResponseEntity.ok().body(arbitre);
    }

    @PutMapping("/arbitres/{id}")
    public ResponseEntity<Arbitre> updateArbitre(
            @PathVariable(value = "id") Long arbitreId,@Valid @RequestBody Arbitre arbitreDetails) throws ResourceNotFoundException {
        Arbitre arbitre = arbitreRepository.findById(arbitreId).orElseThrow(() -> new ResourceNotFoundException("Arbitre introuvable avec le code = " + arbitreId));
        arbitre.setNom_arbitre(arbitreDetails.getNom_arbitre());
        arbitre.setImageArbitre(arbitreDetails.getImageArbitre());

        final Arbitre updatedArbitre = arbitreRepository.save(arbitre);
        return ResponseEntity.ok(updatedArbitre);
    }

    @DeleteMapping("/arbitres/{id}")
    public Map<String, Boolean> deleteArbitre(
            @PathVariable(value = "id") Long arbitreId)
            throws ResourceNotFoundException {
        Arbitre arbitre = arbitreRepository.findById(arbitreId).orElseThrow(() -> new ResourceNotFoundException("Arbitre introuvable avec le code = " + arbitreId));

        arbitreRepository.delete(arbitre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}

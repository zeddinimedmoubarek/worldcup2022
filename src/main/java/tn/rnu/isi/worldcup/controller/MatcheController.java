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
import tn.rnu.isi.worldcup.entities.Matche;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.MatcheRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatcheController {
	@Autowired
    private MatcheRepository matcheRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/matches")
    public List<Matche> getAllMatches() {
        return matcheRepository.findAll();
    }
    
    @PostMapping("/matches")
    public Matche createMatche(@Valid @RequestBody Matche matche) {
        return matcheRepository.save(matche);
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<Matche> getMatcheById(
            @PathVariable(value = "id") Long matcheId)
            throws ResourceNotFoundException {
    	Matche matche = matcheRepository.findById(matcheId)
                .orElseThrow(() -> new ResourceNotFoundException("Matche introuvable avec le code = " + matcheId));
        return ResponseEntity.ok().body(matche);
    }

    @PutMapping("/matches/{id}")
    public ResponseEntity<Matche> updateMatche(
            @PathVariable(value = "id") Long matcheId,@Valid @RequestBody  Matche matcheDetails) throws ResourceNotFoundException {
    	Matche matche= matcheRepository.findById(matcheId).orElseThrow(() -> new ResourceNotFoundException("Matche introuvable avec le code = " + matcheId));
        
       matche.setDate_match(matcheDetails.getDate_match());
       matche.setHeure_match(matcheDetails.getHeure_match());
       matche.setNbr_buts(matcheDetails.getNbr_buts());
        final Matche updatedMatche = matcheRepository.save(matche);
        return ResponseEntity.ok(updatedMatche);
    }

    @DeleteMapping("/matches/{id}")
    public Map<String, Boolean> deleteMatche(
            @PathVariable(value = "id") Long matcheId)
            throws ResourceNotFoundException {
    	Matche matche = matcheRepository.findById(matcheId).orElseThrow(() -> new ResourceNotFoundException("Matche introuvable avec le code = " + matcheId));

        matcheRepository.delete(matche);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

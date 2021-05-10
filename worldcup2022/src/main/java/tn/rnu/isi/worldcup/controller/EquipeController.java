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
import tn.rnu.isi.worldcup.entities.Equipe;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.EquipeRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeController {
	@Autowired
    private EquipeRepository equipeRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/equipes")
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }
    
    @PostMapping("/equipes")
    public Equipe createEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity<Equipe> getEquipeById(
            @PathVariable(value = "id") Long equipeId)
            throws ResourceNotFoundException {
    	Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe introuvable avec le code = " + equipeId));
        return ResponseEntity.ok().body(equipe);
    }

    @PutMapping("/equipes/{id}")
    public ResponseEntity<Equipe> updateEquipe(
            @PathVariable(value = "id") Long equipeId,@Valid @RequestBody Equipe equipeDetails) throws ResourceNotFoundException {
    	Equipe equipe= equipeRepository.findById(equipeId).orElseThrow(() -> new ResourceNotFoundException("Equipe introuvable avec le code = " + equipeId));
        
       equipe.setNom_equipe(equipeDetails.getNom_equipe());
       equipe.setNbr_joueurs(equipeDetails.getNbr_joueurs());
       equipe.setPays(equipeDetails.getPays());
       equipe.setImage_equipe(equipeDetails.getImage_equipe());

        final Equipe updatedEquipe = equipeRepository.save(equipe);
        return ResponseEntity.ok(updatedEquipe);
    }

    @DeleteMapping("/equipes/{id}")
    public Map<String, Boolean> deleteEquipe(
            @PathVariable(value = "id") Long equipeId)
            throws ResourceNotFoundException {
    	Equipe equipe = equipeRepository.findById(equipeId).orElseThrow(() -> new ResourceNotFoundException("Equipe introuvable avec le code = " + equipeId));

        equipeRepository.delete(equipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

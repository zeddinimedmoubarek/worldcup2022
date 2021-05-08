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
import tn.rnu.isi.worldcup.entities.MatcheEquipe;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.MatcheEquipeRepository;
import tn.rnu.isi.worldcup.repository.MatcheRepository;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatcheEquipeController {
	@Autowired
    private MatcheEquipeRepository matcheEquipeRepository;
	@Autowired
	private MatcheRepository matchRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/matcheEquipes")
    public List<MatcheEquipe> getAllMatcheEquipes() {
        return matcheEquipeRepository.findAll();
    }
    
    @PostMapping("/matcheEquipes")
    public MatcheEquipe createMatcheEquipe(@Valid @RequestBody MatcheEquipe matcheEquipe) {
        return matcheEquipeRepository.save(matcheEquipe);
    }

    @GetMapping("/matcheEquipes/{id}")
    public ResponseEntity<MatcheEquipe> getMatcheEquipeById(
            @PathVariable(value = "id") Long matcheEquipeId)
            throws ResourceNotFoundException {
        MatcheEquipe matcheEquipe = matcheEquipeRepository.findById(matcheEquipeId)
                .orElseThrow(() -> new ResourceNotFoundException("MatcheEquipe introuvable avec le code = " + matcheEquipeId));
        return ResponseEntity.ok().body(matcheEquipe);
    }

    @PutMapping("/matcheEquipes/{id}")
    public ResponseEntity<MatcheEquipe> updateMatcheEquipe(
            @PathVariable(value = "id") Long matcheEquipeId,@Valid @RequestBody MatcheEquipe matcheEquipeDetails) throws ResourceNotFoundException {
        MatcheEquipe matcheEquipe = matcheEquipeRepository.findById(matcheEquipeId).orElseThrow(() -> new ResourceNotFoundException("MatcheEquipe introuvable avec le code = " + matcheEquipeId));
        matcheEquipe.setMatche(matcheEquipeDetails.getMatche());
        matcheEquipe.setEquipe1(matcheEquipeDetails.getEquipe1());
        matcheEquipe.setEquipe2(matcheEquipeDetails.getEquipe2());
        matcheEquipe.setNbrButsEq1(matcheEquipeDetails.getNbrButsEq1());
        matcheEquipe.setNbrButsEq1(matcheEquipeDetails.getNbrButsEq2());

        final MatcheEquipe updatedMatcheEquipe = matcheEquipeRepository.save(matcheEquipe);
        return ResponseEntity.ok(updatedMatcheEquipe);
    }

    @DeleteMapping("/matcheEquipes/{id}")
    public Map<String, Boolean> deleteMatcheEquipe(
            @PathVariable(value = "id") Long matcheEquipeId)
            throws ResourceNotFoundException {
        MatcheEquipe matcheEquipe = matcheEquipeRepository.findById(matcheEquipeId).orElseThrow(() -> new ResourceNotFoundException("MatcheEquipe introuvable avec le code = " + matcheEquipeId));

        matcheEquipeRepository.delete(matcheEquipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
  
    
}

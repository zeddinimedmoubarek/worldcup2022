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
import tn.rnu.isi.worldcup.entities.Joueur;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.JoueurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JoueurController {
	@Autowired
    private JoueurRepository joueurRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/joueurs")
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }
    
    @PostMapping("/joueurs")
    public Joueur createJoueur(@Valid @RequestBody Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @GetMapping("/joueurs/{id}")
    public ResponseEntity<Joueur> getJoueurById(
            @PathVariable(value = "id") Long joueurId)
            throws ResourceNotFoundException {
    Joueur joueur = joueurRepository.findById(joueurId)
                .orElseThrow(() -> new ResourceNotFoundException("Joueur introuvable avec le code = " + joueurId));
        return ResponseEntity.ok().body(joueur);
    }

    @PutMapping("/joueurs/{id}")
    public ResponseEntity<Joueur> updateJoueur(
            @PathVariable(value = "id") Long joueurId,@Valid @RequestBody  Joueur joueurDetails) throws ResourceNotFoundException {
    	Joueur joueur= joueurRepository.findById(joueurId).orElseThrow(() -> new ResourceNotFoundException("Joueur introuvable avec le code = " + joueurId));
        
       joueur.setNom_joueur(joueurDetails.getNom_joueur());
       joueur.setEquipe(joueurDetails.getEquipe());
       joueur.setPosition(joueurDetails.getPosition());
       joueur.setImageJoueur(joueurDetails.getImageJoueur());

        final Joueur updatedJoueur = joueurRepository.save(joueur);
        return ResponseEntity.ok(updatedJoueur);
    }

    @DeleteMapping("/joueurs/{id}")
    public Map<String, Boolean> deleteJoueur(
            @PathVariable(value = "id") Long joueurId)
            throws ResourceNotFoundException {
    	Joueur joueur = joueurRepository.findById(joueurId).orElseThrow(() -> new ResourceNotFoundException("Joueur introuvable avec le code = " + joueurId));

        joueurRepository.delete(joueur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

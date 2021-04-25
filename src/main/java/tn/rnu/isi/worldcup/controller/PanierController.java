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

import tn.rnu.isi.worldcup.entities.Panier;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.PanierRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class PanierController {
	@Autowired
    private PanierRepository panierRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/paniers")
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }
    
    @PostMapping("/paniers")
    public Panier createPanier(@Valid @RequestBody Panier panier) {
        return panierRepository.save(panier);
    }

    @GetMapping("/paniers/{id}")
    public ResponseEntity<Panier> getPanierById(
            @PathVariable(value = "id") Long panierId)
            throws ResourceNotFoundException {
    	Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new ResourceNotFoundException("Panier introuvable avec le code = " + panierId));
        return ResponseEntity.ok().body(panier);
    }

    @PutMapping("/paniers/{id}")
    public ResponseEntity<Panier> updatePanier(
            @PathVariable(value = "id") Long panierId,@Valid @RequestBody Panier panierDetails) throws ResourceNotFoundException {
    	Panier panier = panierRepository.findById(panierId).orElseThrow(() -> new ResourceNotFoundException("Panier introuvable avec le code = " + panierId));
        panier.setTickets(panierDetails.getTickets());
        panier.setUser(panierDetails.getUser());
      
        final Panier updatedPanier = panierRepository.save(panier);
        return ResponseEntity.ok(updatedPanier);
    }

    @DeleteMapping("/paniers/{id}")
    public Map<String, Boolean> deletePanier(
            @PathVariable(value = "id") Long panierId)
            throws ResourceNotFoundException {
    	Panier panier = panierRepository.findById(panierId).orElseThrow(() -> new ResourceNotFoundException("Panier introuvable avec le code = " + panierId));

        panierRepository.delete(panier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

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

import tn.rnu.isi.worldcup.entities.Pays;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;
import tn.rnu.isi.worldcup.repository.PaysRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaysController {
	@Autowired
    private PaysRepository paysRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/payss")
    public List<Pays> getAllPayss() {
        return paysRepository.findAll();
    }
    
    @PostMapping("/payss")
    public Pays createPays(@Valid @RequestBody Pays pays) {
        return paysRepository.save(pays);
    }

    @GetMapping("/payss/{id}")
    public ResponseEntity<Pays> getPaysById(
            @PathVariable(value = "id") Long paysId)
            throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId)
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec le code = " + paysId));
        return ResponseEntity.ok().body(pays);
    }

    @PutMapping("/payss/{id}")
    public ResponseEntity<Pays> updatePays(
            @PathVariable(value = "id") Long paysId,@Valid @RequestBody Pays paysDetails) throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId).orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec le code = " + paysId));
        pays.setNomPays(paysDetails.getNomPays());
        pays.setImagePays(paysDetails.getImagePays());

        final Pays updatedPays = paysRepository.save(pays);
        return ResponseEntity.ok(updatedPays);
    }

    @DeleteMapping("/payss/{id}")
    public Map<String, Boolean> deletePays(
            @PathVariable(value = "id") Long paysId)
            throws ResourceNotFoundException {
        Pays pays = paysRepository.findById(paysId).orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec le code = " + paysId));

        paysRepository.delete(pays);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
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
import tn.rnu.isi.worldcup.repository.EntraineurRepository;
import tn.rnu.isi.worldcup.entities.Entraineur;
import tn.rnu.isi.worldcup.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EntraineurController {
	@Autowired
    private EntraineurRepository entraineurRepository;
    
	//@PreAuthorize("hasRole('ADMIN')") // ki hachtik b admin bark ya3mlha
    @GetMapping("/entraineurs")
    public List<Entraineur> getAllEntraineurs() {
        return entraineurRepository.findAll();
    }
    
    @PostMapping("/entraineurs")
    public Entraineur createEntraineur(@Valid @RequestBody Entraineur entraineur) {
        return entraineurRepository.save(entraineur);
    }

    @GetMapping("/entraineurs/{id}")
    public ResponseEntity<Entraineur> getEntraineurById(
            @PathVariable(value = "id") Long entraineurId)
            throws ResourceNotFoundException {
    	Entraineur entraineur = entraineurRepository.findById(entraineurId)
                .orElseThrow(() -> new ResourceNotFoundException("Entraineur introuvable avec le code = " + entraineurId));
        return ResponseEntity.ok().body(entraineur);
    }

    @PutMapping("/entraineurs/{id}")
    public ResponseEntity<Entraineur> updateEntraineur(
            @PathVariable(value = "id") Long entraineurId,@Valid @RequestBody Entraineur entraineurDetails) throws ResourceNotFoundException {
    	Entraineur entraineur = entraineurRepository.findById(entraineurId).orElseThrow(() -> new ResourceNotFoundException("Entraineur introuvable avec le code = " + entraineurId));
        entraineur.setNom_entraineur(entraineurDetails.getNom_entraineur());
        entraineur.setImage_entraineur(entraineur.getImage_entraineur());
        entraineur.setEquipe(entraineur.getEquipe());

        final Entraineur updatedEntraineur = entraineurRepository.save(entraineur);
        return ResponseEntity.ok(updatedEntraineur);
    }

    @DeleteMapping("/entraineurs/{id}")
    public Map<String, Boolean> deleteEntraineur(
            @PathVariable(value = "id") Long entraineurId)
            throws ResourceNotFoundException {
    	Entraineur entraineur = entraineurRepository.findById(entraineurId).orElseThrow(() -> new ResourceNotFoundException("Entraineur introuvable avec le code = " + entraineurId));

        entraineurRepository.delete(entraineur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    

}

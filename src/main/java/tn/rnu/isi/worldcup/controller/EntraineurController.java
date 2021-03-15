package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.repository.EntraineurRepository;

import tn.rnu.isi.worldcup.entities.Entraineur;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EntraineurController {
	
	@Autowired
	private EntraineurRepository entraineurRepository;
	
	@GetMapping("/entraineurs")
	public List<Entraineur> getEntraineurs(){
		return (List<Entraineur>)entraineurRepository.findAll();
	}
	
	@GetMapping("/getentraineur/{id}")
	public Entraineur getEntraineur(Long id) {
		return (Entraineur) entraineurRepository.findEntraineurById(id);
	}
	
	@PostMapping("/addentraineur")
	public void addEntraineur(@RequestBody Entraineur entraineur) {
		entraineurRepository.save(entraineur);
	}

}

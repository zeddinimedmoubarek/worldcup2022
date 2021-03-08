package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Equipe;
import tn.rnu.isi.worldcup.repository.EquipeRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeController {
	@Autowired
	private EquipeRepository equipeRepository;
	
	@GetMapping("/equipes")
	public List<Equipe> getEquipes(){
		return (List<Equipe>) equipeRepository.findAll();
	}
	@GetMapping("/getequipe/{id}")
	public Equipe getEquipe(Long id) {
		return equipeRepository.findEquipeById(id);
	}
	
	@PostMapping("/addequipe")
	void addEquipe(@RequestBody Equipe equipe) {
		equipeRepository.save(equipe);
	}
}

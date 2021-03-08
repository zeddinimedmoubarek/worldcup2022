package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.EquipeMatch;
import tn.rnu.isi.worldcup.repository.EquipeMatchRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeMatchController {
	@Autowired
	private EquipeMatchRepository equipeMatchRepository;
	
	@GetMapping("/equipesMatchs")
	public List<EquipeMatch> getEquipesMatchs(){
		return (List<EquipeMatch>) equipeMatchRepository.findAll();
	}
	@GetMapping("/getequipeMatch/{id}")
	public EquipeMatch getEquipeMatch(Long id) {
		return equipeMatchRepository.findEquipeMatchById(id);
	}
	
	@PostMapping("/addequipeMatch")
	void addEquipeMatch(@RequestBody EquipeMatch equipeMatch) {
		equipeMatchRepository.save(equipeMatch);
	}
}

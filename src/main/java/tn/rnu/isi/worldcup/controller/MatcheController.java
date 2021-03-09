package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.rnu.isi.worldcup.entities.Matche;
import tn.rnu.isi.worldcup.repository.MatcheRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatcheController {
	@Autowired
	private MatcheRepository matcheRepository;
	
	@GetMapping("/matchs")
	public List<Matche> getMatchs(){
		return (List<Matche>) matcheRepository.findAll();
	}
	@GetMapping("/getmatch/{id}")
	public Matche getMatch(Long id) {
		return matcheRepository.findMatchById(id);
	}
	
	@PostMapping("/addmatch")
	void addEquipe(@RequestBody Matche match) {
		matcheRepository.save(match);
	}
}

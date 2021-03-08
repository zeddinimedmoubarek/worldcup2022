package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Match;
import tn.rnu.isi.worldcup.repository.MatchRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {
	@Autowired
	private MatchRepository matchRepository;
	
	@GetMapping("/matchs")
	public List<Match> getMatchs(){
		return (List<Match>) matchRepository.findAll();
	}
	@GetMapping("/getmatch/{id}")
	public Match getMatch(Long id) {
		return matchRepository.findMatchById(id);
	}
	
	@PostMapping("/addmatch")
	void addMatch(@RequestBody Match match) {
		matchRepository.save(match);
	}
}

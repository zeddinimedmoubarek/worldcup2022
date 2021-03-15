package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Joueur;
import tn.rnu.isi.worldcup.repository.JoueurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JoueurController {
	
	@Autowired
	private JoueurRepository joueurRepository;
	
	@GetMapping("/joueurs")
	public List<Joueur> getJoueurs(){
		return (List<Joueur>) joueurRepository.findAll();
	}
	
	@GetMapping("/getjoueur/{id}")
	public Joueur getJoueur(Long id) {
		return (Joueur) joueurRepository.findJoueurById(id);
	}
	
	@PostMapping("/addjoueur")
	public void addJoueur(@RequestBody Joueur joueur) {
		joueurRepository.save(joueur);
	}

}

package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Arbitre;
import tn.rnu.isi.worldcup.repository.ArbitreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArbitreController {
	
	@Autowired
	private ArbitreRepository arbitreRepository;
	
	@GetMapping("/arbitres")
	public List<Arbitre> getArbitres(){
		return (List<Arbitre>) arbitreRepository.findAll();
	}
	
	@GetMapping("/arbitre/{id}")
	public Arbitre getArbitre(Long id) {
		return (Arbitre) arbitreRepository.findArbitreById(id);
	}
	
	@PostMapping("/addarbitre")
	public void addArbitre(@RequestBody Arbitre arbitre) {
		arbitreRepository.save(arbitre);
	}

}

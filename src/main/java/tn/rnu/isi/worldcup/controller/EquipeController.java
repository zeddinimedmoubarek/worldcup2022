package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.Equipe;
import tn.rnu.isi.worldcup.repository.EquipeRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipeController {
	@Autowired
	private EquipeRepository equipeRepository;
	
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/equipes", method = RequestMethod.GET)
	public List<Equipe> getEquipes(){
		return (List<Equipe>) equipeRepository.findAll();
	}
  //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/equipe/{id}", method = RequestMethod.GET)
	public Equipe getEquipe(Long id) {
		return equipeRepository.findEquipeById(id);
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addequipe")
	void addEquipe(@RequestBody Equipe equipe) {
		equipeRepository.save(equipe);
	}
}

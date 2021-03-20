package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Equipe;

public interface EquipeService {
	List<Equipe> getAllEquipe();
	Equipe getEquipeById(Long id);
	Equipe createEquipe(Equipe equipe);
	void deleteEquipe(Long id);
}

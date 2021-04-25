package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.MatcheEquipe;

public interface MatcheEquipeService {
	List<MatcheEquipe> getAllMatcheEquipe();
	MatcheEquipe getMatcheEquipeById(Long id);
	MatcheEquipe createMatcheEquipe(MatcheEquipe joueur);
	void deleteMatcheEquipe(Long id);
}

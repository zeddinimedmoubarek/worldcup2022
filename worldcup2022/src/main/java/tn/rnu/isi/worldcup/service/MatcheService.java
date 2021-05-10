package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Matche;


public interface MatcheService {
	List<Matche> getAllmatches();
	Matche getMatchById(Long id);
	Matche createMatch(Matche matche);
	void deleteMatche(Long id);
	
}

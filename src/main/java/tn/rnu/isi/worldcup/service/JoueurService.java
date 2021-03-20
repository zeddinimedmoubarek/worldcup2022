package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Joueur;

public interface JoueurService {
	List<Joueur> getAllJoueurs();
	Joueur getJoueurById(Long id);
	Joueur createJoueur(Joueur joueur);
	void deleteJoueur(Long id);
}

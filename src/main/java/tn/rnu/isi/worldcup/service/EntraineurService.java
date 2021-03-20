package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Entraineur;


public interface EntraineurService {
	List<Entraineur> getAllEntraineurs();
	Entraineur getEntraineurById(Long id);
	Entraineur createEntraineur(Entraineur entraineur);
	void deleteEntraineur(Long id);
	
}

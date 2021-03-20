package tn.rnu.isi.worldcup.service;


import java.util.List;

import tn.rnu.isi.worldcup.entities.Spectateur;
 
public interface SpectateurService {
	List<Spectateur> getAllSpectateurs();
	Spectateur getSpectateurById(Long id);
	Spectateur createSpectateur(Spectateur spectateur);
	void deleteSpectateur(Long id);
	
}

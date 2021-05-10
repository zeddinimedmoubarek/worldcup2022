package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Arbitre;


public interface ArbitreService {
	List<Arbitre> getAllArbitres();
	Arbitre getArbitreById(Long id);
	Arbitre createArbitre(Arbitre arbitre);
	void deleteArbitre(Long id);
}

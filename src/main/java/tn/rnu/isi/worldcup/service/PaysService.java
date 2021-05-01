package tn.rnu.isi.worldcup.service;

import java.util.List;

import tn.rnu.isi.worldcup.entities.Pays;

public interface PaysService {
	List<Pays> getAllPays();
	Pays getPaysById(Long id);
	Pays createPays(Pays pays);
	void deletePays(Long id);
}

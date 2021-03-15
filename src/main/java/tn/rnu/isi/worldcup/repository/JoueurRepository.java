package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Joueur;

@Repository
public interface JoueurRepository extends CrudRepository<Joueur, Long>{
	public Joueur findJoueurById(@Param("id")Long id);
}

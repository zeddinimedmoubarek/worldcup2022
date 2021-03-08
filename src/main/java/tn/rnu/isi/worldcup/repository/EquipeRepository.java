package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe, Long> {
	public Equipe findEquipeById(@Param("id")Long id);
}

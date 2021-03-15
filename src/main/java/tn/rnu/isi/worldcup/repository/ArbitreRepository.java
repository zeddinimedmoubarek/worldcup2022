package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Arbitre;

@Repository
public interface ArbitreRepository extends CrudRepository<Arbitre, Long>{
	public Arbitre findArbitreById(@Param("id")Long id);

}

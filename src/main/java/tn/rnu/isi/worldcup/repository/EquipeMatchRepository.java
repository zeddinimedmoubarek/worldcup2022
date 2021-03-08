package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.EquipeMatch;




@Repository
public interface EquipeMatchRepository extends CrudRepository<EquipeMatch, Long> {
	public EquipeMatch findEquipeMatchById(@Param("id")Long id);

}

package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.worldcup.entities.Matche;



@Repository
public interface MatcheRepository extends CrudRepository<Matche, Long> {
	public Matche findMatchById(@Param("id")Long id);
}

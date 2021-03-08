package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
	public Match findMatchById(@Param("id")Long id);

}

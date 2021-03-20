package tn.rnu.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.worldcup.entities.Matche;



@Repository
public interface MatcheRepository extends JpaRepository<Matche, Long> {
	
}

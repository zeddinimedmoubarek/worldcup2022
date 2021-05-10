package tn.rnu.isi.worldcup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.ETournoi;
import tn.rnu.isi.worldcup.entities.Tournoi;



@Repository
public interface TournoiRepository extends JpaRepository<Tournoi,Long> {
	Optional<Tournoi> findByName(ETournoi name);
}
package tn.rnu.isi.worldcup.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.worldcup.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
}
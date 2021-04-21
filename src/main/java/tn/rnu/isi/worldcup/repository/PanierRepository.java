package tn.rnu.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

}

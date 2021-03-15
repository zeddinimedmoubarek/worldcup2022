package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.Entraineur;

@Repository
public interface EntraineurRepository extends CrudRepository<Entraineur, Long>{
	public Entraineur findEntraineurById(@Param("id")Long id);

}

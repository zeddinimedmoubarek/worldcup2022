package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}

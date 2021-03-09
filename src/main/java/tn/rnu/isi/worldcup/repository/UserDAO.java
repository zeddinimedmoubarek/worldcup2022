package tn.rnu.isi.worldcup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.worldcup.entities.*;
@Repository
public interface UserDAO extends CrudRepository<User, Long> {
	User findByUsername(String username);
}

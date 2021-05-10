package tn.rnu.isi.worldcup.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.rnu.isi.worldcup.entities.ERole;
import tn.rnu.isi.worldcup.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByName(ERole name);
}

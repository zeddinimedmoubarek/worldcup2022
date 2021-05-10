package tn.rnu.isi.worldcup.repository;

import java.util.Optional; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isi.worldcup.entities.ImageModel; 
@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> 
{ Optional<ImageModel> findByName(String name);
boolean existsByName(String nomFile);
}

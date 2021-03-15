package tn.rnu.isi.worldcup.config;

import java.util.List;
import tn.rnu.isi.worldcup.entities.UserDto;
import tn.rnu.isi.worldcup.entities.User;
public interface UserService {
	User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}

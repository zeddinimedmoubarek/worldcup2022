package tn.rnu.isi.worldcup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.rnu.isi.worldcup.entities.User;
import tn.rnu.isi.worldcup.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(Long id) {
		return userRepository.findUserById(id);
	}
	
	@PostMapping("/adduser")
	void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
}

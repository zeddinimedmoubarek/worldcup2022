package tn.rnu.isi.worldcup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.rnu.isi.worldcup.config.*;
import tn.rnu.isi.worldcup.entities.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/token")
public class AuthenticationController {
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenProvider jwtTokenUtil;

	    @Autowired
	    private UserService userService;

	    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getUsername(),
	                        loginUser.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        return ResponseEntity.ok(new AuthToken(token));
	    }

}

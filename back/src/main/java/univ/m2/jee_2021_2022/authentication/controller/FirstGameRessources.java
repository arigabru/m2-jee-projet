package univ.m2.jee_2021_2022.authentication.controller;


import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;
import univ.m2.jee_2021_2022.authentication.models.AuthenticationResponse;
import univ.m2.jee_2021_2022.authentication.services.UserService;
import univ.m2.jee_2021_2022.authentication.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FirstGameRessources {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

	//Authentifier; retourne le token, param : mail et password 
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest usermodel) throws Exception {

		AuthenticationRequest auth =  userDetailsService.getOneUserByEmail(usermodel.getEmail());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		
		try {
			if(encoder.matches(usermodel.getPassword(), auth.getPassword())){
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usermodel.getEmail(), auth.getPassword()));
			}
		}
		catch (BadCredentialsException e) {
			//throw new Exception("Incorrect username or password", e);	
			return new ResponseEntity("{\"information\" : \"Incorrect username or password\"}" ,HttpStatus.BAD_REQUEST);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(usermodel.getEmail());
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, auth.getPseudo(), auth.getEmail()));
	}
    
}

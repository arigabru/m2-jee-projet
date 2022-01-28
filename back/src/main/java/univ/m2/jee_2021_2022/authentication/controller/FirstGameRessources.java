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

	public BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

	//Authentifier; retourne le token, param : mail et password 
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest usermodel) throws Exception {

		if (!userDetailsService.findUserFromEmail(usermodel.getEmail())){
            return new ResponseEntity("{\"information\" : \"user not exist\"}" ,HttpStatus.NOT_FOUND);
        } 
		AuthenticationRequest auth =  userDetailsService.getOneUserByEmail(usermodel.getEmail());
		
		
		
		try {
			System.out.println(usermodel.getPassword());
			System.out.println(auth.getPassword());
			
			//System.out.println(encoder.matches(usermodel.getPassword().toString(), auth.getPassword().toString()));

			if(encoder.matches(usermodel.getPassword().toString(), auth.getPassword().toString())){
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usermodel.getEmail(), auth.getPassword()));
				final UserDetails userDetails = userDetailsService.loadUserByUsername(usermodel.getEmail());
				final String jwt = jwtTokenUtil.generateToken(userDetails);

				return ResponseEntity.ok(new AuthenticationResponse(jwt, auth.getPseudo(), auth.getEmail()));
			}else {
				new ResponseEntity("{\"information\" : \"Incorrect username or password\"}" ,HttpStatus.BAD_REQUEST);
			}
		}
		catch (BadCredentialsException e) {
			//throw new Exception("Incorrect username or password", e);	
			return new ResponseEntity("{\"information\" : \"Incorrect username or password\"}" ,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity("{\"information\" : \"Incorrect username or password\"}" ,HttpStatus.BAD_REQUEST);

		
	}
	public BCryptPasswordEncoder getEncoder() {
		return encoder;
	}
    
}

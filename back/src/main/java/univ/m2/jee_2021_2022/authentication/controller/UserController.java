package univ.m2.jee_2021_2022.authentication.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;
import univ.m2.jee_2021_2022.authentication.models.Games;
import univ.m2.jee_2021_2022.authentication.services.GamesServices;
import univ.m2.jee_2021_2022.authentication.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserService userService ;

    @Autowired 
    private GamesServices gamesServices ;

    @GetMapping(value="/api/users")
    public ResponseEntity<List<AuthenticationRequest>> getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping(value="/api/newuser")
    public ResponseEntity<?> createNewUser(@RequestBody AuthenticationRequest auth){

        if (!auth.getPassword().toString().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$")){
            return new ResponseEntity("{\"information\" : \"password not valid\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (!validate(auth.getEmail().toString())){
            return new ResponseEntity("{\"information\" : \"mail not valid\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserFromEmail(auth.getEmail())){
            return new ResponseEntity("{\"information\" : \"user already exist\"}" ,HttpStatus.BAD_REQUEST);   
        }

        return ResponseEntity.ok(userService.addUser(new AuthenticationRequest(auth.getPseudo(), auth.getPassword(), auth.getEmail(), false)));
        
    }
    
    @PostMapping(value="/api/users")
    public ResponseEntity<?> createUser(@RequestBody AuthenticationRequest auth){

        if (!auth.getPassword().toString().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$")){
            return new ResponseEntity("{\"information\" : \"password not valid\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (!validate(auth.getEmail().toString())){
            return new ResponseEntity("{\"information\" : \"mail not valid\"}" ,HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserFromEmail(auth.getEmail())){
            return new ResponseEntity("{\"information\" : \"user already exist\"}" ,HttpStatus.BAD_REQUEST);
        }
    
        return ResponseEntity.ok(userService.addUser(auth));
        
    }

    @GetMapping(value="/api/users/mail")
    public ResponseEntity<AuthenticationRequest> getUserByMail(@RequestParam(value ="mail") String mail){

        if (!userService.findUserFromEmail(mail)){
            return new ResponseEntity("{\"information\" : \"user not exist\"}" ,HttpStatus.NOT_FOUND);
        }
        AuthenticationRequest user = userService.getOneUserByEmail(mail);
        
        //retrait des mots de passe  
        user.setPassword(null);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value="/api/users/delete")
    public ResponseEntity<?> deleteUserByMail(@RequestParam(value ="mail") String mail){
        if (!userService.findUserFromEmail(mail)){
            return new ResponseEntity("{\"information\" : \"user not exist\"}" ,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userService.deleteUserByMail(mail));
    }

    @GetMapping(value="/api/games/informations")
    public Games getInformations(){
        return gamesServices.getInformationGames();
    }

    @PostMapping(value="/api/games/informations")
    public Games updatesGamesInformations(@RequestBody Games g){
        return gamesServices.UpdatesInfomationsGames(g);
    }

    Boolean matchesPolicy(String pwd) {
        if (pwd.length() < 8) return false;
        if (! pwd.matches("/[a-z]/") ) return false;
        if (! pwd.matches("/[A-Z]/") ) return false;
        if (! pwd.matches("/[0-9]/") ) return false;
        return true;
    }
    
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
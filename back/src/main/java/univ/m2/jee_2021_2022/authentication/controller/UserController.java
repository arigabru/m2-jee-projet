package univ.m2.jee_2021_2022.authentication.controller;

import java.util.List;

import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;
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
    
    @Autowired
    private UserService userService ;

    //Récup liste users
    @GetMapping(value="/api/users")
    public ResponseEntity<List<AuthenticationRequest>> getUser(){

        return ResponseEntity.ok(userService.getUsers());
    }
    
    //Créer user
    @PostMapping(value="/api/users")
    public ResponseEntity<?> createUser(@RequestBody AuthenticationRequest auth){

        System.out.println ("L'utilisateur existe ? "+userService.getOneUserByEmail(auth.getEmail()).equals(null));
        if (!userService.findUserFromEmail(auth.getEmail())){
            return ResponseEntity.ok(userService.addUser(auth));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }

    //Recup user par mail
    @GetMapping(value="/api/users/mail")
    public ResponseEntity<AuthenticationRequest> getUserByMail(@RequestParam(value ="mail") String mail){

        return ResponseEntity.ok(userService.getOneUserByEmail(mail));
    }

    //Suppr user (ne fonctionne pas)
    @DeleteMapping(value="/api/delete/users")
    public ResponseEntity<?> deleteUserByMail(@RequestParam(value ="mail") String mail){
        
        if (userService.getOneUserByEmail(mail) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userService.deleteUserByMail(mail));
    }
}

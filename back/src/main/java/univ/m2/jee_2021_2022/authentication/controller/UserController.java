package univ.m2.jee_2021_2022.authentication.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    private UserService userService ;

    @GetMapping(value="/api/users")
    public ResponseEntity<List<AuthenticationRequest>> getUser(){

        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping(value="/api/newuser")
    public ResponseEntity<?> createNewUser(@RequestBody AuthenticationRequest auth){

        if (!auth.getPassword().toString().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$")){
            System.out.println("le mot de passe contient pas ce qu'il faut");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!validate(auth.getEmail().toString())){
            System.out.println("le mail n'est pas un mail");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userService.findUserFromEmail(auth.getEmail())){
            return ResponseEntity.ok(userService.addUser(new AuthenticationRequest(auth.getPseudo(), auth.getPassword(), auth.getEmail(), false)));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
    @PostMapping(value="/api/users")
    public ResponseEntity<?> createUser(@RequestBody AuthenticationRequest auth){

        System.out.println ("L'utilisateur existe ? "+userService.getOneUserByEmail(auth.getEmail()).equals(null));
        if (!userService.findUserFromEmail(auth.getEmail())){
            return ResponseEntity.ok(userService.addUser(auth));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }

    @GetMapping(value="/api/users/mail")
    public ResponseEntity<AuthenticationRequest> getUserByMail(@RequestParam(value ="mail") String mail){
        
        AuthenticationRequest user = userService.getOneUserByEmail(mail);
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value="/api/users/delete")
    public ResponseEntity<?> deleteUserByMail(@RequestParam(value ="mail") String mail){
        System.out.println(mail);
        if (userService.getOneUserByEmail(mail) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userService.deleteUserByMail(mail));
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
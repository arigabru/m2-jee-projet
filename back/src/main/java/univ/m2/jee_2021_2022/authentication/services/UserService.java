package univ.m2.jee_2021_2022.authentication.services;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.AuthStatus;

import univ.m2.jee_2021_2022.authentication.Repository.UserRepository;
import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    
    @Autowired 
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) {
        AuthenticationRequest auth = getOneUserByEmail(mail);
        System.out.println("/n/n "+mail);
        System.out.println("/n/n "+auth.getEmail());
        if (auth == null) {
            throw new UsernameNotFoundException(mail);
        }
        UserDetails user ;
        if (auth.getAdministrator()){
            user = User.withUsername(auth.getEmail()).password(auth.getPassword()).authorities("ADMIN").build();
        }else {
            user = User.withUsername(auth.getEmail()).password(auth.getPassword()).authorities("USER").build();
        }
        
        return user ;
    }

    public List<AuthenticationRequest> getUsers(){

        List<AuthenticationRequest> responseListUser = new ArrayList<AuthenticationRequest>();
        for (AuthenticationRequest us : userRepository.findAll()){
            responseListUser.add(new AuthenticationRequest(us));
        }
        return responseListUser;
    }

    public AuthenticationRequest addUser(AuthenticationRequest auth) {
        return userRepository.insert(auth);
    }

    public AuthenticationRequest getOneUserByEmail(String mail){
       
        for (AuthenticationRequest us : userRepository.findAll()){ 
            if (us.getEmail().equals(mail))
            {
                return us;
            }
                
        }
        return new AuthenticationRequest();
        
    }

    public ResponseEntity<String> deleteUserByMail(String mail) {
        
        //userRepository.deleteAll();
        
        userRepository.delete(getOneUserByEmail(mail));
        
        return ResponseEntity.ok("Delete succes");
    }

    public Boolean findUserFromEmail(String mail){
        for (AuthenticationRequest us : userRepository.findAll()){ 
            if (us.getEmail().equals(mail))
            {
                return true;
            }
                
        }
        return false;
    }
    
}

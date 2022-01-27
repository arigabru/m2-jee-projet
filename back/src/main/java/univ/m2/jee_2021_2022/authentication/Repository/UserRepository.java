package univ.m2.jee_2021_2022.authentication.Repository;

import java.util.ArrayList;

import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;
import univ.m2.jee_2021_2022.authentication.services.UserService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepository extends MongoRepository<AuthenticationRequest,Long>{
    AuthenticationRequest findByEmail(String email);
    
    
}

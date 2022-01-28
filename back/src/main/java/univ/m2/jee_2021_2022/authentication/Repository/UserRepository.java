package univ.m2.jee_2021_2022.authentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;

public interface UserRepository extends MongoRepository<AuthenticationRequest,Long>{
    AuthenticationRequest findByEmail(String email);
    
    
}

package univ.m2.jee_2021_2022.authentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import univ.m2.jee_2021_2022.authentication.models.Games;

public interface GamesRepository extends MongoRepository<Games, Long>{
    public Games getOneById(int i);
    
}

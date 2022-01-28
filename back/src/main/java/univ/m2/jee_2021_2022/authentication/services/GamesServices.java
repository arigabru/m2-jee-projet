package univ.m2.jee_2021_2022.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.m2.jee_2021_2022.authentication.Repository.GamesRepository;
import univ.m2.jee_2021_2022.authentication.models.Games;

@Service
public class GamesServices {
    
    @Autowired
    GamesRepository gamesRepository ;

    public Games createGamesServices(Games g){
        return gamesRepository.insert(g);
    }

    public Games getInformationGames(){
        //return gamesRepository.findAll();
        return gamesRepository.getOneById(1);
    }

    public Games UpdatesInfomationsGames(Games g){
        gamesRepository.deleteById((long) 1);
        return createGamesServices(g);
    }

}

package univ.m2.jee_2021_2022;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import univ.m2.jee_2021_2022.authentication.models.AuthenticationRequest;
import univ.m2.jee_2021_2022.authentication.models.Games;
import univ.m2.jee_2021_2022.authentication.services.GamesServices;
import univ.m2.jee_2021_2022.authentication.services.UserService;

@SpringBootApplication
public class Jee20212022Application {

	public static void main(String[] args) {
		SpringApplication.run(Jee20212022Application.class, args);
		
	}
	
	 @Bean
     CommandLineRunner run(UserService userService, GamesServices gamesServices){
         return  args -> {
              gamesServices.createGamesServices(new Games(1,true, true, true));
              userService.addUser(new AuthenticationRequest("professor", "MotDePasse1","professor@gmail.com", true));
              userService.addUser(new AuthenticationRequest("bruno", "MotDePasse2", "bruno@gmail.com", false));
         };
     }
}

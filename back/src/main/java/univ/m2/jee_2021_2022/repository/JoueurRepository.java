package univ.m2.jee_2021_2022.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import univ.m2.jee_2021_2022.model.bataille.Joueur;

@Repository
public interface JoueurRepository extends CrudRepository<Joueur, Integer> {
}

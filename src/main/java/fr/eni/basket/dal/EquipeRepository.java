package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository {

    List<Equipe> findAllEquipes();

    Optional<Equipe> findEquipeByNom(String nomEquipe);
}

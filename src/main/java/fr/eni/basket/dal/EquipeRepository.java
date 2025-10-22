package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;

import java.util.List;

public interface EquipeRepository {

    List<Equipe> findAllEquipes();
}

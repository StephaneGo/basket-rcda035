package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;

import java.util.List;

public interface EquipeService {

    /* Retourne la liste de toutes les équipes */
    List<Equipe> getEquipes();

    Equipe addEquipe(EquipeDTO equipeDTO);

}

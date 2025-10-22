package fr.eni.basket.bll;


import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EquipeServiceTest {

    @Autowired
    private EquipeServiceTestImpl equipeService;


    @Test
    @DisplayName("Test d'ajout d'une équipe cas nominal")
    public void testAddEquipeCasNominal(){
        //AAA
        //Arrange
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(new Equipe(1, "U15F1"));
        equipes.add(new Equipe(2, "U15F2"));
        equipes.add(new Equipe(3, "U18M1"));
        equipeService.setEquipes(equipes);
        EquipeDTO equipeDTO = new EquipeDTO("unNomDEquipe");

        //Act
        Equipe newEquipe = equipeService.addEquipe(equipeDTO);

        //Assert
        assertNotNull(newEquipe);
        assertEquals(equipeDTO.nom(), newEquipe.getNom());
        assertEquals(4, newEquipe.getNoEquipe());
        equipes = equipeService.getEquipes();
        assertEquals(4, equipes.size());

    }

    @Test
    @DisplayName("test getAllEquipes Cas : des equipes existent")
    public void testGetAllEquipesCasDesEquipesExistent()
    {
        //AAA
        //Arrange
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(new Equipe(1, "U15F1"));
        equipes.add(new Equipe(2, "U15F2"));
        equipes.add(new Equipe(3, "U18M1"));
        equipeService.setEquipes(equipes);

        //Act
        List<Equipe> resultat = equipeService.getEquipes();

        //Assert
        assertNotNull(resultat);
        assertEquals(resultat.size(), equipes.size());


    }

}

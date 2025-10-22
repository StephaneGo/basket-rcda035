package fr.eni.basket.bll;

import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipeServiceTestImpl implements EquipeService {

    private Set<Equipe> equipes;
    private static int indexNoEquipe = 1;

    private EquipeServiceTestImpl() {
        this.equipes = new HashSet<Equipe>();
        this.equipes.add(new Equipe(indexNoEquipe++, "U15F1"));
        this.equipes.add(new Equipe(indexNoEquipe++, "U15F2"));
        this.equipes.add(new Equipe(indexNoEquipe++, "U18M1"));
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = new HashSet<>(equipes);
    }

    @Override
    public List<Equipe> getEquipes() {
        return equipes.stream().toList();
    }

    @Override
    public Equipe addEquipe(EquipeDTO equipeDTO) {
        Equipe newEquipe = new Equipe();
        BeanUtils.copyProperties(equipeDTO, newEquipe);
        newEquipe.setNoEquipe(indexNoEquipe++);

        equipes.add(newEquipe);

        return newEquipe;
    }
}

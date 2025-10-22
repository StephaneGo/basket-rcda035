package fr.eni.basket.controllers;

import fr.eni.basket.bll.EquipeService;
import fr.eni.basket.bo.Equipe;
import fr.eni.basket.dto.EquipeDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipeRestController {
    private EquipeService equipeService;

    public EquipeRestController( EquipeService equipeService){
        this.equipeService = equipeService;
    }

    @GetMapping("/equipes")
    public List<Equipe> findAllEquipes() {

        return equipeService.getEquipes();
    }

    @PostMapping("/equipes")
    public ResponseEntity<Equipe> addEquipe(@Valid @RequestBody EquipeDTO equipeDto
            , BindingResult result){
        Equipe equipe = null;
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(null);
        }

        equipe = equipeService.addEquipe(equipeDto);

        return ResponseEntity.ok(equipe);
    }

}

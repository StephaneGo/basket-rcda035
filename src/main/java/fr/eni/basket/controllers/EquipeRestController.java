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
import org.springframework.web.bind.annotation.*;

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

    //Supprimer une équipe connaissant son numéro
    @DeleteMapping("/equipes/{noEquipe}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable("noEquipe") int noEquipe) {
        //truc
        boolean resultat = equipeService.deleteEquipe(noEquipe);
        if (!resultat) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping ("/equipes")
    public ResponseEntity<Void> deleteUneEquipe(@RequestParam("noEquipe") int noEquipe) {
        boolean resultat = equipeService.deleteEquipe(noEquipe);
        if (!resultat) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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

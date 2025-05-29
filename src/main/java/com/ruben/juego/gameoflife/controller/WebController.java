package com.ruben.juego.gameoflife.controller;

import com.ruben.juego.gameoflife.model.GameState;
import com.ruben.juego.gameoflife.service.GameOfLifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private GameOfLifeService gameOfLifeService;

    @GetMapping("/juego")
    public String juego() {
        return "forward:/index.html";
    }

    @GetMapping("/api/game-state")
    public GameState getGameState() {
        return gameOfLifeService.getCurrentState();
    }

    @PostMapping("/api/next-generation")
    @ResponseBody
    public GameState nextGeneration() {
        gameOfLifeService.avanzarGeneracion();
        return gameOfLifeService.getCurrentState();
    }

    @PostMapping("/api/reset")
    @ResponseBody
    public void reset() {
        gameOfLifeService.reiniciarJuego();
    }
}
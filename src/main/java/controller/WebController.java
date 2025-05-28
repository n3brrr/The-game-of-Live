package controller;

import model.GameState;
import org.springframework.web.bind.annotation.RestController;
import service.GameOfLifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

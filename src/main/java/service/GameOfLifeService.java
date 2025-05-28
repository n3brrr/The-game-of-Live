package service;

import model.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameOfLifeService {
    private boolean[][] grid;

    public GameOfLifeService() {
        // Inicializa con un tamaño y patrón fijo por ahora
        grid = new boolean[10][10];
        grid[1][2] = true;
        grid[2][3] = true;
        grid[3][1] = true;
        grid[3][2] = true;
        grid[3][3] = true;
    }

    public GameState getCurrentState() {
        return new GameState(grid);
    }

    public void nextGeneration() {
        // Lógica para calcular la próxima generación (opcional ahora)
    }
}

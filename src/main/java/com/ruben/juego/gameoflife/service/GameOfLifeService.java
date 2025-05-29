package com.ruben.juego.gameoflife.service;

import com.ruben.juego.gameoflife.model.GameState;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GameOfLifeService {
    private boolean[][] grid;
    private static final int MAX_GENERATIONS = 100;
    private AtomicInteger currentGeneration = new AtomicInteger(0);
    private AtomicBoolean isRunning = new AtomicBoolean(false);

    public GameOfLifeService() {
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

    public void avanzarGeneracion() {
        if (currentGeneration.get() < MAX_GENERATIONS) {
            boolean[][] nextGeneration = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int neighbors = countNeighbors(i, j);
                    if (grid[i][j]) {
                        nextGeneration[i][j] = neighbors == 2 || neighbors == 3;
                    } else {
                        nextGeneration[i][j] = neighbors == 3;
                    }
                }
            }
            grid = nextGeneration;
            currentGeneration.incrementAndGet();
        }
    }

    public int countNeighbors(int i, int j) {
        int count = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                int ni = i + x, nj = j + y;
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
                    if (grid[ni][nj]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void startSimulation() {
        if (!isRunning.get()) {
            isRunning.set(true);
            new Thread(() -> {
                while (isRunning.get()) {
                    avanzarGeneracion();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void stopSimulation() {
        isRunning.set(false);
    }

    public void reiniciarJuego() {
        grid = new boolean[10][10];
        currentGeneration.set(0);
    }
}
package model;

public class GameState {
    private boolean[][] cells;

    public GameState(boolean[][] cells) {
        this.cells = cells;
    }

    public boolean[][] getCells() {
        return cells;
    }

    public void setCells(boolean[][] cells) {
        this.cells = cells;
    }
}

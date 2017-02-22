package com.gfk.conway;

public enum Cell {
    Alive, Dead;

    public Cell nextGeneration(int neighbours) {
        if (neighbours == 3) {
            return Alive;
        }
        if (neighbours == 2 && isAlive(this)) {
            return Alive;
        }
        return Dead;
    }

    public static boolean isAlive(Cell cell) {
        return Alive.equals(cell);
    }
}

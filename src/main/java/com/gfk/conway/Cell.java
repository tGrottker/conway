package com.gfk.conway;

public enum Cell {
    Alive, Dead;

    public Cell nextGeneration(int neighbours) {
        if (neighbours == 2 || neighbours == 3) {
            return Alive;
        }
        return Dead;
    }
}

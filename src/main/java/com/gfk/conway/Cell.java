package com.gfk.conway;

public enum Cell {
    Alive, Dead;

    public Cell nextGeneration(int neighbours) {
        return Dead;
    }
}

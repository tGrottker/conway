package com.gfk.conway;

public class Board {

    private Cell[][] population;

    public Board(Cell[][] population) {
        this.population = population;
    }

    public int countNeighbours(int x, int y) {
        int neighbours = 0;
        for (int i = Math.max(0, y - 1); i < Math.min(population.length, y + 2); i++) {
            for (int j = Math.max(0, x - 1); j < Math.min(population[i].length, x + 2); j++ ) {
                if (Cell.isAlive(population[i][j])) {
                    neighbours += 1;
                }
            }
        }
        if (Cell.isAlive(population[y][x])) {   // count only neighbours
            return neighbours - 1;
        }
        return neighbours;
    }
}

package com.gfk.conway;

public class Board {

    final Cell[][] population;

    public Board(Cell[][] population) {
        this.population = population;
    }

    public Board(int width, int height) {
        population = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                population[i][j] = Cell.random();
            }
        }
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

    public Board nextGeneration() {
        Cell[][] nextGeneration = new Cell[population.length][population[0].length];
        for (int i = 0; i < nextGeneration.length; i++) {
            for (int j = 0; j < nextGeneration[0].length; j ++) {
                nextGeneration[i][j] =  population[i][j].nextGeneration(countNeighbours(j, i));
            }
        }
        return new Board(nextGeneration);
    }
}

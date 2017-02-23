package com.gfk.conway;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Cell {
    Alive, Dead;

    private static final List<Cell> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random GENERATOR = new Random();

    public static Cell random() {
            return VALUES.get(GENERATOR.nextInt(SIZE));
    }

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

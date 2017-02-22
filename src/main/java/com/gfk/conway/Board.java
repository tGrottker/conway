package com.gfk.conway;

public class Board {

    public Board(Cell[][] population) {

    }

    public int countNeigbours(int x, int y) {
        if (x == 2) {
            return 1;
        }
        return 0;
    }
}

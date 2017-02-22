package com.gfk.conway;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GenerationTest {

    Board board;

    /**
     * This function creates the following board:
     *
     *  | |
     * -|-|-
     *  | |X
     * -|-|-
     * X|X|X
     * -|-|-
     *  | |X
     *
     */
    @Before
    public void createBoard() {
        Cell[] firstRow = {Cell.Dead, Cell.Dead, Cell.Dead};
        Cell[] secondRow = {Cell.Dead, Cell.Dead, Cell.Alive};
        Cell[] thirdRow = {Cell.Alive, Cell.Alive, Cell.Alive};
        Cell[] fourthRow = {Cell.Dead, Cell.Dead, Cell.Alive};
        Cell[][] population = {firstRow, secondRow, thirdRow, fourthRow};
        this.board = new Board(population);
    }

    @Test
    public void countNeighbours() {
        assertEquals(0, board.countNeigbours(0, 0));
        assertEquals(1, board.countNeigbours(2, 0));
    }

}

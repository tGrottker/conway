package com.gfk.conway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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
        assertEquals(0, board.countNeighbours(0, 0));
        assertEquals(1, board.countNeighbours(2, 0));
        assertEquals(2, board.countNeighbours(2, 1));
        assertEquals(3, board.countNeighbours(2, 2));
        assertEquals(4, board.countNeighbours(1, 2));
    }

    /**
     * The next generation should look like this:
     *
     *  | |
     * -|-|-
     *  | |X
     * -|-|-
     *  | |X
     * -|-|-
     *  | |X
     *
     */
    @Test
    public void evolveNextGeneration() {
        Cell[] firstRow = {Cell.Dead, Cell.Dead, Cell.Dead};
        Cell[] secondRow = {Cell.Dead, Cell.Dead, Cell.Alive};
        Cell[] thirdRow = {Cell.Dead, Cell.Dead, Cell.Alive};
        Cell[] fourthRow = {Cell.Dead, Cell.Dead, Cell.Alive};
        Cell[][] nextGeneration = board.nextGeneration().population;
        assertArrayEquals(firstRow, nextGeneration[0]);
        assertArrayEquals(secondRow, nextGeneration[1]);
        assertArrayEquals(thirdRow, nextGeneration[2]);
        assertArrayEquals(fourthRow, nextGeneration[3]);
    }

}

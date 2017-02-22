package com.gfk.conway;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LifeRuleTest {

    @Test
    public void aliveCellDiesByUnderpopulation() {
        Cell cell = Cell.Alive;
        assertEquals(Cell.Dead, cell.nextGeneration(1));
        assertEquals(Cell.Dead, cell.nextGeneration(0));
    }

    @Test
    public void aliveCellStaysAlive() {
        Cell cell = Cell.Alive;
        assertEquals(Cell.Alive, cell.nextGeneration(2));
        assertEquals(Cell.Alive, cell.nextGeneration(3));
    }

    @Test
    public void aliveCellDiesByOverpopulation() {
        Cell cell = Cell.Alive;
        assertEquals(Cell.Dead, cell.nextGeneration(4));
        assertEquals(Cell.Dead, cell.nextGeneration(5));
        assertEquals(Cell.Dead, cell.nextGeneration(6));
        assertEquals(Cell.Dead, cell.nextGeneration(7));
        assertEquals(Cell.Dead, cell.nextGeneration(8));
    }

}

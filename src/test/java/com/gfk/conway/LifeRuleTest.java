package com.gfk.conway;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LifeRuleTest {

    @Test
    public void aliveCellWithLessThanOneNeighbourDies() {
        Cell cell = Cell.Alive;
        assertEquals(Cell.Dead, cell.nextGeneration(1));
        assertEquals(Cell.Dead, cell.nextGeneration(0));
    }

}

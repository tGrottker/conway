# Game of Life

This project contains the implementation of
[Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)
as part of a recruitment test. Conway's Game of Life is a simple
turn-based mathematical simulation of living and dieing cells.

## Rules

The rules of the game are as follows:

1. Any alive cell with less than 2 neighbours dies.
2. Any cell with 2 or 3 neighbours lives in the next generation.
3. Any alive cell with more than 3 neighbours dies.
4. Any dead cell with exactly 3 neighbours becomes alive in the next
generation.

After each turn the next generation is computed based on those rules.

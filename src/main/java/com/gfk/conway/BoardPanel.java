package com.gfk.conway;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private static int BOARD_WIDTH = 50;
    private static int BOARD_HEIGHT = 50;
    private static int CELL_SIZE = 10;
    private Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);


    public BoardPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(BOARD_WIDTH * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCells(g);
        drawGird(g);
    }

    public void restart() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        repaint();
    }

    public void evolve() {
        board = board.nextGeneration();
        repaint();
    }

    private void drawCells(Graphics g) {
        Cell[][] population = board.population;
        int height = population.length;
        int width = population[0].length;
        g.setColor(Color.GREEN);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Cell.isAlive(population[y][x])) {
                    g.fillRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private void drawGird(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.BLACK);
        for (int i = 0; i < width; i += 10) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < height; i += 10) {
            g.drawLine(0, i, width, i);
        }
    }

}

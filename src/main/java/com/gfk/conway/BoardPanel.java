package com.gfk.conway;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    private Board board = new Board(50, 50);

    public BoardPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(500, 500));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCells(g);
        drawGird(g);
    }

    private void drawCells(Graphics g) {
        Cell[][] population = board.population;
        int height = population.length;
        int width = population[0].length;
        g.setColor(Color.GREEN);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (Cell.isAlive(population[y][x])) {
                    g.fillRect(x*10, y*10, 10, 10);
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

package com.gfk.conway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel implements ActionListener {

    private static int BOARD_WIDTH = 50;
    private static int BOARD_HEIGHT = 50;
    private static int CELL_SIZE = 10;
    private Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
    private boolean autoPlay = false;
    private Timer redrawTimer = new Timer(500, this);


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
        autoPlay = false;
        redrawTimer.stop();
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        repaint();
    }

    public void evolve() {
        board = board.nextGeneration();
        repaint();
    }

    public void toggleAutoPlay() {
        autoPlay = !autoPlay;
        if (autoPlay) {
            redrawTimer.start();
        } else {
            redrawTimer.stop();
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        evolve();
        redrawTimer.restart();
    }
}

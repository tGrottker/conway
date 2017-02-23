package com.gfk.conway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Visualization extends JFrame {

    private BoardPanel boardPanel = new BoardPanel();

    public Visualization() {
        initUI();
    }

    private void initUI() {
        createLayout();
        setTitle("Game of Life");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createLayout() {
        Container pane = getContentPane();
        BorderLayout layout = new BorderLayout();
        pane.setLayout(layout);
        pane.add(boardPanel, BorderLayout.WEST);
        pane.add(createButtons(), BorderLayout.EAST);
    }

    private Container createButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton newGame = new JButton("New Game");
        newGame.addActionListener((ActionEvent) -> {
            boardPanel.restart();
        });
        panel.add(newGame);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton evolve = new JButton("Evolve");
        evolve.addActionListener((ActionEvent) -> {
            boardPanel.evolve();
        });
        panel.add(evolve);

        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Visualization visualization = new Visualization();
            visualization.setVisible(true);
        });
    }

}

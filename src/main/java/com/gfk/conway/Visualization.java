package com.gfk.conway;

import javax.swing.*;
import java.awt.*;

public class Visualization extends JFrame {

    private BoardPanel boardPanel = new BoardPanel();

    public Visualization() {
        initUI();
    }

    private void initUI() {
        createLayout();
        setTitle("Game of Life");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createLayout() {
        Container pane = getContentPane();
        BorderLayout layout = new BorderLayout();
        layout.setHgap(10);
        pane.setLayout(layout);
        pane.add(boardPanel, BorderLayout.WEST);
        pane.add(createButtons(), BorderLayout.CENTER);
        pane.add(new JPanel(), BorderLayout.EAST);
    }

    private Container createButtons() {
        Dimension buttonSize = new Dimension(300, 25);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(170));
        JButton newGame = new JButton("New Game");
        newGame.setMaximumSize(buttonSize);
        newGame.addActionListener((ActionEvent) -> {
            boardPanel.restart();
        });
        panel.add(newGame);
        panel.add(Box.createVerticalStrut(15));

        JButton evolve = new JButton("Evolve");
        evolve.setMaximumSize(buttonSize);
        evolve.addActionListener((ActionEvent) -> {
            boardPanel.evolve();
        });
        panel.add(evolve);
        panel.add(Box.createVerticalStrut(15));

        JButton autoPlay = new JButton("Play/Pause");
        autoPlay.setMaximumSize(buttonSize);
        autoPlay.addActionListener((ActionEvent) -> {
            boardPanel.toggleAutoPlay();
        });
        panel.add(autoPlay);

        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Visualization visualization = new Visualization();
            visualization.setVisible(true);
        });
    }

}

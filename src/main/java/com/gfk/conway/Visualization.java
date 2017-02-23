package com.gfk.conway;

import javax.swing.*;
import java.awt.*;

public class Visualization extends JFrame {

    private JPanel boardPanel = new BoardPanel();

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
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Visualization visualization = new Visualization();
            visualization.setVisible(true);
        });
    }

}

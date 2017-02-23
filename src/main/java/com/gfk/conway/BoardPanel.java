package com.gfk.conway;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public BoardPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(500, 500));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGird(g);
    }

    private void drawGird(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < width; i += 10) {
            g.drawLine(i, 0, i, height);
        }
        for (int i = 0; i < height; i += 10) {
            g.drawLine(0, i, width, i);
        }
    }

}

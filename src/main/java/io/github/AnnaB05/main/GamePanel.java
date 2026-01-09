package io.github.AnnaB05.main;

import javax.swing.*;
import java.awt.*;
/**
 * panel for game graphics to be drawn
 */
public class GamePanel extends JPanel {

    public GamePanel() {
    }

    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);

    }
}

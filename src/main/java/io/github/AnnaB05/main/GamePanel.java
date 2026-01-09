package io.github.AnnaB05.main;

import io.github.AnnaB05.inputs.KeyboardInputs;
import io.github.AnnaB05.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * panel for game graphics to be drawn
 */
public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;

    public GamePanel() {
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 50);

    }
}

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
    private int xDelta = 0;
    private int yDelta = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }
    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);

    }
}

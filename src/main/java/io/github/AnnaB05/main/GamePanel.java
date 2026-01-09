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
    private float xDelta = 100, yDelta = 100;
    private float xDir = 0.01f, yDir = 0.01f;
    private int frames = 0;
    private long lastCheck = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int value) {
        this.xDelta += value;

    }
    public void changeYDelta(int value) {
        this.yDelta += value;

    }

    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;

    }

    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();

        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        repaint();

    }

    public void updateRectangle() {
       xDelta += xDir;
       if (xDelta > 400 || xDelta < 0)
           xDir = -1;
       yDelta += yDir;
       if (yDelta > 400 || yDelta < 0)
           yDir = -1;
    }
}

package io.github.AnnaB05.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
                System.out.println("W key pressed");
                break;
            case KeyEvent.VK_A:
                System.out.println("A key pressed");
                break;
            case KeyEvent.VK_S:
                System.out.println("S key pressed");
                break;
            case KeyEvent.VK_D:
                System.out.println("D key pressed");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

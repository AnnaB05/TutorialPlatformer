package io.github.AnnaB05.main;

import javax.swing.*;

/**
 * class for game window
 * uses jframe to hold game panel
 **/
public class GameWindow {
    private JFrame jframe;
    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(400, 400); // Set the size of the window
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when window is closed
        jframe.add(gamePanel); // Add the game panel to the window
        jframe.setLocationRelativeTo(null); // Center the window on the screen
        jframe.setVisible(true); // Make the window visible

    }
}

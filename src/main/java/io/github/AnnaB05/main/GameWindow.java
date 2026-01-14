package io.github.AnnaB05.main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * class for game window
 * uses jframe to hold game panel
 **/
public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();


        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when window is closed
        jframe.add(gamePanel); // Add the game panel to the window
        jframe.setLocationRelativeTo(null); // Center the window on the screen
        jframe.setResizable(false); // Prevent resizing of the window
        jframe.pack(); // Adjust the window size to fit the preferred size of its components
        jframe.setVisible(true); // Make the window visible
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {


            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("BYEE");
            }
        });

    }
}

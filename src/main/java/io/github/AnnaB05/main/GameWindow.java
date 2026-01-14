package io.github.AnnaB05.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;

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

        //this should allow the panel to request focus after visible
        SwingUtilities.invokeLater(gamePanel::requestFocusInWindow);

        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                gamePanel.requestFocusInWindow(); // this should keep the game from disappearing when clicking outside the game window


            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }
        });

        addTrayIcon();


    }
    /**
     *  add system tray icon with restore and exit options
     * this should fix the issue of the game being inaccessible when minimized
     * using a default icon for now since I'm not sure if I'm going to keep this implementation
     **/
    private void addTrayIcon() {
        if (!SystemTray.isSupported()) return;

        //try catch prevents the game from crashing if system tray is not supported
        try {
            SystemTray tray = SystemTray.getSystemTray();

            // creates a tiny default icon img since I'm not yet ready to use a custom one
            Image image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) image.getGraphics();
            g2.setColor(Color.YELLOW);
            g2.fillOval(0, 0, 15, 15);
            g2.dispose();

            PopupMenu popup = new PopupMenu(); //creates a pop-up menu when user right-clicks the icon

            MenuItem restoreItem = new MenuItem("Restore");
            restoreItem.addActionListener((ActionEvent e) -> restoreWindow());
            popup.add(restoreItem);

            //exit menu option removes the icon and exits the game
            MenuItem exitItem = new MenuItem("Exit");
            exitItem.addActionListener((ActionEvent e) -> {
                tray.remove(new TrayIcon(image));
                System.exit(0);
            });
            popup.add(exitItem);

            TrayIcon trayIcon = new TrayIcon(image, "Game", popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener((ActionEvent e) -> restoreWindow());

            tray.add(trayIcon);
        } catch (Exception ex) {

            ex.printStackTrace(); // log any errors
        }
    }
    /**
     *  restore the game window from system tray
     *
     *  */
    private void restoreWindow() {
        SwingUtilities.invokeLater(() -> {
            //checks if the frame is minimized or not visible, then restores and brings to front
            if (jframe.getState() == Frame.ICONIFIED) {
                jframe.setState(Frame.NORMAL);
            }
            if (!jframe.isVisible()) {
                jframe.setVisible(true);
            }

            jframe.toFront(); //brings window to the front
            jframe.requestFocus(); //requests input focus for the window
            //ensures the game panel gets keyboard focus
            Component content = jframe.getContentPane().getComponent(0);
            if (content instanceof GamePanel) {
                ((GamePanel) content).requestFocusInWindow();
            }
        });
    }
}

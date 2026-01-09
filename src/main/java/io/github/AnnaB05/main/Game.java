package io.github.AnnaB05.main;

/**
 * game class holds everything together
 * this is where everything  will start
 */
public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

    }
}

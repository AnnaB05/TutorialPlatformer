package io.github.AnnaB05.main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);

    }
}

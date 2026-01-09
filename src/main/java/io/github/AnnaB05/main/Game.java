package io.github.AnnaB05.main;

/**
 * game class holds everything together
 * this is where everything  will start
 */
public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;

    /** constructor for Game **/
    public Game() {

        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();

    }

    //method for gameThread
    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * this is the where the game loop will be
     */
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET; //each frame should last 1 million nanoseconds
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while(true) {

            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {

                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }


            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);  //prints frames per second to console
                frames = 0; //resets frame count
            }



        }

    }
}

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
    private final int UPS_SET = 200;

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
        double timePerUpdate = 1000000000.0 / UPS_SET; //each update should last 1 million nanoseconds


        int frames = 0;
        int updates = 0;

        long lastCheck = System.currentTimeMillis();
        long previousTime = System.nanoTime();

        double deltaU = 0;
        double deltaF = 0;

        while(true) {


            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate; //calculates how many updates are needed
            deltaF += (currentTime - previousTime) / timePerFrame; //calculates how many frames are needed
            previousTime = currentTime;
            if (deltaU >= 1) { //prevents lost time from being wasted and instead adds lost time to the next update
                // update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            /*if(now - lastFrame >= timePerFrame) { //if enough time has passed, renders the next frame
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }*/


            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " UPS: " + updates);  //prints frames per second to console
                frames = 0; //resets frame count
                updates = 0; //resets update count
            }



        }

    }
}

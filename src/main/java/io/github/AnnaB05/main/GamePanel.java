package io.github.AnnaB05.main;

import io.github.AnnaB05.inputs.KeyboardInputs;
import io.github.AnnaB05.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


/**
 * panel for game graphics to be drawn
 */
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100; //sets rect's initial position
    private BufferedImage img;
    private BufferedImage[] idleAni; // array to hold idle animation frames
    private int aniTick, aniIndex, aniSpeed = 15;



    public GamePanel() {

        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        setPanelSize(); // sets panel size
        setFocusable(true); // allows panel to receive focus and key inputs

    }

    private void loadAnimations() {
        idleAni = new BufferedImage[10];

        for(int i =0; i < idleAni.length; i++) {
            idleAni[i] = img.getSubimage(i*32, 0, 32, 32);
        }
    }

    private void importImg() {

        try (InputStream is = getClass().getResourceAsStream("/YellowGuy.png")) {
            if (is == null) {
                throw new RuntimeException("Resource `/YellowGuy.png` not found");
            }
            img = ImageIO.read(is);
            if (img == null) {
                throw new RuntimeException("Failed to read `/YellowGuy.png`");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // sets panel size
    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

    private void updateAnimationTick() {

        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex ++;
            if(aniIndex >= idleAni.length) {
                aniIndex = 0;
            }
        }
    }
    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();
        g.drawImage(idleAni[aniIndex],(int)xDelta,(int)yDelta,90,80,null);
    }




}

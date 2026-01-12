package io.github.AnnaB05.entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static io.github.AnnaB05.utilz.Constants.Directions.*;
import static io.github.AnnaB05.utilz.Constants.Directions.DOWN;
import static io.github.AnnaB05.utilz.Constants.PlayerConstants.*;

public class Player extends Entity {
    private BufferedImage[][] animations; // array to hold idle animation frames
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updateAnimationTick();
        setAnimation(); // sets player animation based on input
        updatePos(); // updates player position based on input
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y,90,80,null); //no need for observer at the moment
    }

    public void setDirection(int direction) {
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving (boolean moving) {
        this.moving = moving;
    }

    //method for updating animation tick
    private void updateAnimationTick() {

        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex ++;
            if(aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }

    /// method that sets player animation based on input
    private void setAnimation() {
        int startAni = playerAction;
        if(moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    /// method for updating player position
    private void updatePos() {
        if(moving) {
            switch (playerDir) {
                case LEFT:
                    x -= 5;
                    break;
                case RIGHT:
                    x += 5;
                    break;
                case UP:
                    y -= 5;
                    break;
                case DOWN:
                    y += 5;
                    break;
            }
        }
    }

    /// method for handling the player character's animations
    private void loadAnimations() {

        InputStream is = getClass().getResourceAsStream("/YellowGuy.png");
        try {
            BufferedImage img = ImageIO.read(is);
            animations = new BufferedImage[7][12]; // 7 animations, with the highest frame count being 12
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 32, j * 32, 32, 32);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
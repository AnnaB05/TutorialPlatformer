package io.github.AnnaB05.entities;

import io.github.AnnaB05.utilz.loadSave;

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
    private boolean moving = false, attacking = false;
    private boolean left, right, up, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updatePos(); // updates player position based on input
        updateAnimationTick();
        setAnimation(); // sets player animation based on input

    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex],(int)x,(int)y,90,80,null); //no need for observer at the moment
    }


    //method for updating animation tick
    private void updateAnimationTick() {

        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex ++;
            if(aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
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

        if(attacking) {
            playerAction = ATTACK;
        }

        if(startAni != playerAction) {
            aniIndex = 0;
            aniTick = 0;
        }
    }

    /// method for updating player position
    private void updatePos() {

        moving = false;

        // if statement for left and right movement
        if (left && !right) {
            x -= playerSpeed;
            moving = true;
        } else if (right && !left) {
            x += playerSpeed;
            moving = true;
        }

        // if statement for up and down movement
        if (up && !down) {
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }
    }

    /// method for handling the player character's animations
    private void loadAnimations() {


            BufferedImage img = loadSave.GetPlayerAtlas();
            animations = new BufferedImage[7][12]; // 7 animations, with the highest frame count being 12
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 32, j * 32, 32, 32);
                }
            }

        }





    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public boolean isAttacking () {
        return attacking;
    }
    public void setAttacking (boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
}
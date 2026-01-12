package io.github.AnnaB05.entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity {
    private BufferedImage[][] animations; // array to hold idle animation frames
    public Player(float x, float y) {
        super(x, y);
    }

    public void update() {
        // Update player state
    }

    public void render() {
        // Render player on screen
    }

    /// method for handling the player character's animations
    private void loadAnimations() {

        InputStream is = getClass().getResourceAsStream("/YellowGuy.png");


        /*try (InputStream is = getClass().getResourceAsStream("/YellowGuy.png")) {

            if (is == null) {
                throw new RuntimeException("Resource `/YellowGuy.png` not found");
            }
            img = ImageIO.read(is);
            if (img == null) {
                throw new RuntimeException("Failed to read `/YellowGuy.png`");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }
}

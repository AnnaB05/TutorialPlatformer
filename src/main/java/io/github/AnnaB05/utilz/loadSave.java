package io.github.AnnaB05.utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadSave {
    public static BufferedImage GetPlayerAtlas() {
        BufferedImage img = null;
        InputStream is = loadSave.class.getResourceAsStream("/YellowGuy.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;

    }
}

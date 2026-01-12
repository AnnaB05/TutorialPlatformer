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

import static io.github.AnnaB05.utilz.Constants.PlayerConstants.*;
import static io.github.AnnaB05.utilz.Constants.Directions.*;


/**
 * class where game graphics will be drawn
 */
public class GamePanel extends JPanel {

    public Object getGame;
    private MouseInputs mouseInputs;
    private Game game;



    /// method for displaying the game panel
    public GamePanel(Game  game) {

        mouseInputs = new MouseInputs(this);
        this.game = game;


        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        setPanelSize(); // sets panel size
        setFocusable(true); // allows panel to receive focus and key inputs

    }


    // sets panel size
    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        /*setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);*/
    }

    public void updateGame() {
    }
    /**
     * allows for drawing graphics on the panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        game.render(g);
    }

    public Game getGame() {
        return game;
    }




}

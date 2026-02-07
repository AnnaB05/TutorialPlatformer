package io.github.AnnaB05.main;

import io.github.AnnaB05.inputs.KeyboardInputs;
import io.github.AnnaB05.inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

import static io.github.AnnaB05.main.Game.GAME_HEIGHT;
import static io.github.AnnaB05.main.Game.GAME_WIDTH;


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
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

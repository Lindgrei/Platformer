package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private final Game game;


    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(GamePanel.this);
        this.game = game;
        addKeyListener(new KeyBoardInputs(GamePanel.this));

        setPanelSize();

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void updateGame() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }


    public Game getGame() {
        return game;
    }
}
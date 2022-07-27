package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;

public class GamePanel extends JPanel {
    private int xPos = 100, yPos = 100;

    private final MouseInputs mouseInputs;

    public GamePanel() {
        mouseInputs = new MouseInputs(GamePanel.this);
        System.out.println("init GamePanel");
        addKeyListener(new KeyBoardInputs(GamePanel.this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXPos(int val) {
        this.xPos += val;
        repaint();
    }

    public void changeYPos(int val) {
        this.yPos += val;
        repaint();
    }

    public void setRectPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        repaint();
    }


    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.fillRect(xPos, yPos, 200, 50);
    }
}


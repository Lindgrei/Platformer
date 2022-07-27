package main;

import javax.swing.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        System.out.println("init GamePanel");
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");
        g.drawRect(400, 300, 200, 50);
    }
}


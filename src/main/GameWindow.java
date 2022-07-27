package main;

import javax.swing.*;

public class GameWindow {
    private final JFrame jframe;

    public GameWindow(GamePanel gamePanel) {

        jframe = new JFrame();
        jframe.setLocationRelativeTo(null);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);

    }
}

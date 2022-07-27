package main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public Game() {
        System.out.println("init Game");
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);


    }
}

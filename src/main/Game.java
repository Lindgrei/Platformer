package main;

public class Game implements Runnable {
    private final int FPS = 120;
    int frames = 0;
    long lastCheck = System.currentTimeMillis();
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private Thread gameThread;

    public Game() {
        System.out.println("init Game");
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();


    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double timePerTick = 1000000000.0 / FPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();


        while (true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerTick) {
                lastFrame = now;
                gamePanel.repaint();
                frames++;

            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                lastCheck = System.currentTimeMillis();
            }


        }
    }
}


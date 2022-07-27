package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {
    private final GamePanel gamePanel;

    public KeyBoardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_W:
                gamePanel.changeYPos(-10);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXPos(-10);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYPos(10);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXPos(10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

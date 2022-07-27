package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private final long lastCheck = 0;
    private final int frames = 0;
    private final int animSpeed = 15;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private float xPos = 100, yPos = 100;
    private int animTick;
    private int animIndex;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;

    public GamePanel() {
        mouseInputs = new MouseInputs(GamePanel.this);
        addKeyListener(new KeyBoardInputs(GamePanel.this));
        importImg();
        loadAnimations();
        setPanelSize();

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void setDirection(int direction){
        this.playerDirection = direction;
        moving = true;

    }

    public void setIdle(boolean moving){
        this.moving = moving;
    }

    private void updateAnimationTick() {
        animTick++;
        if (animTick >= animSpeed) {
            animTick = 0;
            animIndex++;
            if (animIndex >= GetSpriteAmount(playerAction)) {
                animIndex = 0;
            }


        }

    }

    private void setAnimation() {
        if(moving)
            playerAction = RUNNING;
        else
            playerAction = IDLE;
    }

    private void updatePos() {
        if (moving) {
            switch (playerDirection) {
                case UP:
                    yPos -= 5;
                    break;
                case DOWN:
                    yPos += 5;
                    break;
                case LEFT:
                    xPos -= 5;
                    break;
                case RIGHT:
                    xPos += 5;
                    break;
            }
        }
    }


    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        updatePos();

        setAnimation();

        g.drawImage(animations[playerAction][animIndex], (int) xPos, (int) yPos, 256, 160, null);


    }

}


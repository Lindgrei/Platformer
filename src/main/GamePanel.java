package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    private final MouseInputs mouseInputs;
    private final long lastCheck = 0;
    private final int frames = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private float xPos = 100, yPos = 100;
    private int animTick;
    private int animIndex;
    private final int animSpeed = 15;
    private int playerAction = IDLE;

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
        for(int j = 0; j < animations.length; j++)
        for (int i = 0; i < animations[j].length; i++) {
            animations[j][i] = img.getSubimage(i * 64, j*40, 64, 40);
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

    public void setRectPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void changeXPos(int val) {
        this.xPos += val;

    }

    public void changeYPos(int val) {
        this.yPos += val;

    }

    private void updateAnimationTick() {
        animTick++;
        if (animTick >= animSpeed) {
            animTick = 0;
            animIndex++;
            if (animIndex >= 6) {
                animIndex = 0;
            }



        }

    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();

        g.drawImage(animations[playerAction][animIndex], (int) xPos, (int) yPos, 128, 80, null);


    }

}


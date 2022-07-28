package entities;

import utils.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private final int animSpeed = 15;
    private BufferedImage img;
    private int animTick;
    private int animIndex;
    private int playerAction = IDLE;
    public boolean moving = false, attacking = false;

    private boolean left, right, up, down;

    private BufferedImage[][] animations;

    private final float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updateAnimationTick();
        updatePos();

        setAnimation();


    }

    public void render(Graphics g) {

        g.drawImage(animations[playerAction][animIndex], (int) x, (int) y, 256, 160, null);

    }


    private void updateAnimationTick() {
        animTick++;
        if (animTick >= animSpeed) {
            animTick = 0;
            animIndex++;
            if (animIndex >= GetSpriteAmount(playerAction)) {
                animIndex = 0;
                attacking = false;
            }


        }

    }

    private void setAnimation() {

        int startAni = playerAction;

        if (moving) playerAction = RUNNING;
        else playerAction = IDLE;

        if (attacking) playerAction = ATTACK_1;


        if (playerAction != startAni) resetAniTick();




    }

    private void resetAniTick() {
        animIndex = 0;
        animTick = 0;
    }

    private void updatePos() {
        moving = false;

        if (left && !right) {
            x -= playerSpeed;
            moving = true;

        } else if (right && !left) {
            x += playerSpeed;
            moving = true;
        }

        if (up && !down) {
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }


    }


    private void loadAnimations() {

        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }


    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }


    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }


    public void resetDirBools(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

}


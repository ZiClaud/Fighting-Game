package characters;

import window.Game;
import window.GameObject;
import window.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private final int playerWidth;
    private final int playerHeight;
    private int hp;
    private BufferedImage img;
    private int i = 0;
    private PlayerAnimationType playerAnimationType = PlayerAnimationType.Idle;

    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.hp = hp;

        animatePlayer();
    }

    public PlayerAnimationType getPlayerAnimationType() {
        return playerAnimationType;
    }

    public void setPlayerAnimationType(PlayerAnimationType playerAnimationType) {
        this.playerAnimationType = playerAnimationType;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private void animatePlayer() {
        Timer timer = new Timer(200, e -> {
            if (i >= PlayerImg.getPlayerImg(playerAnimationType).size()) {
                i = 0;
            }
            img = PlayerImg.getPlayerImg(playerAnimationType).get(i);
            i++;
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    private void loopAnimation(){

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        checkWall();
    }

    private void checkWall() {
        if (x <= 0 || x >= Game.WIDTH - playerWidth) {
            velX = 0;
            if (x <= 0) x = 0;
            if (x >= Game.WIDTH - playerWidth) x = Game.WIDTH - playerWidth;
        }
        if (y <= 0 || y >= Game.HEIGHT - playerHeight) {
            velY = 0;
            if (y <= 0) y = 0;
            if (y >= Game.HEIGHT - playerHeight) y = Game.HEIGHT - playerHeight;
        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.drawImage(img, x, y, null);
        } else if (id == ID.Enemy) {
            g.setColor(Color.RED);
            g.fillRect(x, y, playerWidth, playerHeight);
        }
    }
}

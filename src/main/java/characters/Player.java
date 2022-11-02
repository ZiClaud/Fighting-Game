package characters;

import window.Game;
import window.GameObject;
import window.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    int playerWidth;
    int playerHeight;
    int hp;
    BufferedImage img;
    int i = 0;
    PlayerAnimationType playerAnimationType = PlayerAnimationType.Idle;

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        wall();
    }

    private void wall() {
        if (x <= -playerWidth / 2 || x >= Game.WIDTH - playerWidth / 2) {
            velX = 0;
            if (x <= -playerWidth / 2)
                x = -playerWidth / 2;
            if (x >= Game.WIDTH - playerWidth / 2)
                x = Game.WIDTH - playerWidth / 2;
        }
        if (y <= -playerHeight / 2 || y >= Game.HEIGHT - playerHeight * 2 / 3) {
            velY = 0;
            if (y <= -playerHeight / 2)
                y = -playerHeight / 2;
            if (y >= Game.HEIGHT - playerHeight * 2 / 3)    // TODO: CHECK
                y = Game.HEIGHT - playerHeight * 2 / 3;
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

        /*
        if (id == ID.Player) {
            g.drawImage(img, x, y, null);
        }
         */
//        if (id == ID.Player) g.setColor(Color.WHITE);

    }
}

package characters;

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

    public PlayerAnimationType getPlayerAnimationType() {
        return playerAnimationType;
    }

    public void setPlayerAnimationType(PlayerAnimationType playerAnimationType) {
        this.playerAnimationType = playerAnimationType;
    }

    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.hp = hp;

        animatePlayer();
    }

    private void animatePlayer(){
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

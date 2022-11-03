package characters;

import window.Game;
import window.GameObject;
import window.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private final int playerWidth;
    private final int playerHeight;
    private int hp;
    private BufferedImage img;
    private PlayerAnimationType playerAnimationType = PlayerAnimationType.Idle;

    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);
        this.playerWidth = playerWidth;
        this.playerHeight = playerHeight;
        this.hp = hp;

        new AnimatePlayer(this).animatePlayer();
    }

    public PlayerAnimationType getPlayerAnimationType() {
        return playerAnimationType;
    }

    public void setPlayerAnimationType(PlayerAnimationType playerAnimationType) {
        this.playerAnimationType = playerAnimationType;
        /*
        // TODO: This fixes bug that stops animation if I both jump and go right, but can't attack
        if (velX == 0 && velY == 0){
            this.playerAnimationType = PlayerAnimationType.Idle;
        } else if (velY < 0){
            this.playerAnimationType = PlayerAnimationType.Jump;
        } else if (velY > 0) {
            this.playerAnimationType = PlayerAnimationType.Fall;
        } else if (velX > 0){
            this.playerAnimationType = PlayerAnimationType.Run;
        } else if (velX < 0){
            this.playerAnimationType = PlayerAnimationType.RunLeft;
        }
        */
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
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

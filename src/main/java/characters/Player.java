package characters;

import window.Game;
import window.GameObject;
import window.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private int hp;
    private BufferedImage img;
    private PlayerAnimationType playerAnimationType = PlayerAnimationType.Idle;

    private final PlayerSize size;

    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);
        this.hp = hp;

        this.size = new PlayerSize(playerWidth, playerHeight);

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
        if (x <= -size.getWidthToRemoveFromLeft() || x >= Game.WIDTH - size.getImgWidth() - size.getWidthToAddFromRight()) {
            velX = 0;
            if (x <= -size.getWidthToRemoveFromLeft()) {
                x = -size.getWidthToRemoveFromLeft();
            } else if (x >= Game.WIDTH - size.getImgWidth() - size.getWidthToAddFromRight()) {
                x = Game.WIDTH - size.getImgWidth() - size.getWidthToAddFromRight();
            }
        }
        if (y <= -size.getHeightToAddFromTop() || y >= Game.HEIGHT - size.getImgHeight() - size.getHeightToRemoveFromBottom()) {
            velY = 0;
            if (y <= -size.getHeightToAddFromTop()) {
                y = -size.getHeightToAddFromTop();
            } else if (y >= Game.HEIGHT - size.getImgHeight() - size.getHeightToRemoveFromBottom()) {
                y = Game.HEIGHT - size.getImgHeight() - size.getHeightToRemoveFromBottom();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.drawImage(img, x, y, null);
        } else if (id == ID.Enemy) {
            g.setColor(Color.RED);
            g.fillRect(x, y, size.getImgWidth(), size.getImgHeight());
//            g.fillRect(x, y, size.getActualWidth(), size.getActualHeight());  // TODO: FIX THIS BUG
        }
    }

    public PlayerSize getSize() {
        return size;
    }
}

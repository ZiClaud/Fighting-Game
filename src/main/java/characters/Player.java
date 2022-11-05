package characters;

import window.Game;
import window.GameObject;
import window.ID;

import java.awt.*;

public class Player extends GameObject {
    private int hp;
    private final PlayerImage playerImage;

    private final PlayerSize size;

    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);     // TODO: x - size.removeWidth, y - size.removeHeight;
        this.hp = hp;

        this.size = new PlayerSize(playerWidth, playerHeight);
        this.playerImage = new PlayerImage();

        new AnimatePlayer(this).animatePlayer();
    }

    public PlayerImage getPlayerImage() {
        return playerImage;
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

        checkWall();
    }

    private void checkWall() {
        /**
         * Right/Left Wall
         */
        if (size.getActualX(x) <= 0 || size.getActualRightX(x) >= Game.WIDTH) {
            velX = 0;
            if (size.getActualX(x) <= 0) {
                x = -size.getExcessiveLeft();
            } else if (size.getActualRightX(x) >= Game.WIDTH) {
                x = Game.WIDTH - size.getImgWidth() + size.getExcessiveRight();
            }
        }
        /**
         * Top/Bottom Wall
         */
        if (size.getActualY(y) <= 0 || size.getActualBottomY(y) >= Game.HEIGHT) {
            velY = 0;
            if (size.getActualY(y) <= 0) {
                y = -size.getExcessiveTop();
            } else if (size.getActualBottomY(y) >= Game.HEIGHT) {
                y = Game.HEIGHT - size.getImgHeight() + size.getExcessiveBottom();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.drawImage(playerImage.getImg(), x, y, null);
        } else if (id == ID.Enemy) {
            g.setColor(Color.RED);
            g.fillRect(x, y, size.getImgWidth(), size.getImgHeight());
//            g.fillRect(x, y, size.getActualWidth(), size.getActualHeight());  // TODO: USE TO CHECK -> THERE'S NO BUG
        }
    }

    public PlayerSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "";
    }
}

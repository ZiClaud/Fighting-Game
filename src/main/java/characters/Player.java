package characters;

import window.Game;
import window.GameObject;
import window.ID;

import java.awt.*;

public class Player extends GameObject {
    private int hp;
    private PlayerData playerData;


    public Player(int x, int y, ID id, int playerWidth, int playerHeight, int hp) {
        super(x, y, id);     // TODO: x - size.removeWidth, y - size.removeHeight;
        this.hp = hp;

        this.playerData = new PlayerData(this, playerWidth, playerHeight);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        playerData.getAction().act();

        checkWall();
    }

    private void checkWall() {
        /**
         * Right/Left Wall
         */
        if (playerData.getSize().getActualX(x) <= 0 || playerData.getSize().getActualRightX(x) >= Game.WIDTH) {
            velX = 0;
            if (playerData.getSize().getActualX(x) <= 0) {
                x = -playerData.getSize().getExcessiveLeft();
            } else if (playerData.getSize().getActualRightX(x) >= Game.WIDTH) {
                x = Game.WIDTH - playerData.getSize().getImgWidth() + playerData.getSize().getExcessiveRight();
            }
        }
        /**
         * Top/Bottom Wall
         */
        if (playerData.getSize().getActualY(y) <= 0 || playerData.getSize().getActualBottomY(y) >= Game.HEIGHT) {
            velY = 0;
            if (playerData.getSize().getActualY(y) <= 0) {
                y = -playerData.getSize().getExcessiveTop();
            } else if (playerData.getSize().getActualBottomY(y) >= Game.HEIGHT) {
                y = Game.HEIGHT - playerData.getSize().getImgHeight() + playerData.getSize().getExcessiveBottom();
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(playerData.getPlayerImage().getImg(), x, y, null);
    }

    /*
//    WAS IN RENDER
     if (id == ID.Player) {
         g.drawImage(playerImage.getImg(), x, y, null);
     } else if (id == ID.Enemy) {
         g.drawImage(playerImage.getImg(), x, y, null);
         // g.setColor(Color.RED);
         // g.fillRect(x, y, size.getImgWidth(), size.getImgHeight());

         // g.fillRect(x, y, size.getActualWidth(), size.getActualHeight());  // TODO: USE TO CHECK -> THERE'S NO BUG
     }
    */

}

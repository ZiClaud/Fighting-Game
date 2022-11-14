package characters;

import actions.Action;
import utils.Events;
import window.GameObject;
import window.ID;

import java.awt.*;

public class PlayerClass extends GameObject implements PlayerInterface {
    private final String username;
    private int hp;
    private final PlayerImage playerImage;
    private final PlayerSize size;
    private final Action action;
    private final AnimatePlayer animatePlayer;

    public PlayerClass(int x, int y, ID id, int playerWidth, int playerHeight, int hp, String username) {
        super(x, y, id);     // TODO: x - size.removeWidth, y - size.removeHeight;
        this.hp = hp;
        this.username = username;

        this.size = new PlayerSize(playerWidth, playerHeight);
        this.playerImage = new PlayerImage();

        this.action = new Action(this);
        this.animatePlayer = new AnimatePlayer(this);

        animatePlayer.animatePlayer();
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

    public String getUsername() {
        return username;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        action.act();

        Events.checkWall(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(playerImage.getImg(), x, y, null);
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

    public PlayerSize getSize() {
        return size;
    }

    public Action getAction() {
        return action;
    }
}
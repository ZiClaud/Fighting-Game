package characters;

import actions.Action;
import actions.AnimatePlayer;
import utils.Events;
import window.GameObject;
import window.ID;

import java.awt.*;

public class PlayerClass extends GameObject implements PlayerInterface {    // TODO: Make this class way less complicated
    private final String username;
    private final PlayerImage playerImage;
    private final PlayerSizeInterface size;
    private final Action action;
    private final AnimatePlayer animatePlayer;
    private int hp;

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

    public AnimatePlayer getAnimatePlayer() {
        return animatePlayer;
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

    public PlayerSizeInterface getSize() {
        return size;
    }

    public Action getAction() {
        return action;
    }
}

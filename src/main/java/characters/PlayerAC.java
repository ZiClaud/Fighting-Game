package characters;

import actions.AnimatePlayer;
import actions.imgsFactory.Skin;
import characters.box.PlayerSize;
import events.Events;
import utils.MyUtils;
import window.game.GameObject.ID;
import window.game.GameObject.MovingGameObject;

import java.awt.*;

public class PlayerAC extends MovingGameObject implements CharacterInt {
    private final String username;
    private final PlayerImage playerImage;
    private final PlayerSizeInt size;
    private final AnimatePlayer animatePlayer;
    private int hp;
    private Skin skin;
    private boolean showDevSquare = false;

    public PlayerAC(int x, int y, ID id, int hp, String username, Skin skin) {
        super(x, y, id);     // TODO: x - size.removeWidth, y - size.removeHeight;
        this.hp = hp;
        this.username = username;
        this.skin = skin;

        this.size = new PlayerSize(skin);
        this.playerImage = new PlayerImage();
        this.animatePlayer = new AnimatePlayer(this);

        animatePlayer.animatePlayer();
    }

    @Override
    public PlayerImage getPlayerImage() {
        return playerImage;
    }

    @Override
    public AnimatePlayer getAnimatePlayer() {
        return animatePlayer;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isShowDevSquare() {
        return showDevSquare;
    }

    @Override
    public void setShowDevSquare(boolean showDevSquare) {
        this.showDevSquare = showDevSquare;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        getAnimatePlayer().getAction().act();

        Events.checkWall(this);

        Events.jump(this);

        Events.stopCharacter(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(playerImage.getImg(), x, y, null);

        if (showDevSquare) {
            // Middle
            g.setColor(Color.blue);
            g.drawRect(size.getMiddleX(x), size.getMiddleY(y), 1, 1);

            /// Image size
            MyUtils.drawRectDev(g, Color.gray, this.size.getImgWH(), x, y);

            /// Actual image size
            MyUtils.drawRectDev(g, Color.white, this.size.getActualImgWH(), x, y);

            /// Damage size
            MyUtils.drawRectDev(g, Color.red, this.size.getDamageWH(), x, y);
/*
            g.setColor(Color.red);
            if (animatePlayer.getAction().isFacingRight()) {
                g.drawRect(size.getActualX(x), size.getActualY(y), size.getActualWidth() + size.getActualWidth() / 2, size.getActualHeight());
                // TODO: Fix: remove orange -1 fix fighting in Size class -2 fix public static boolean isXInAttackRange(...)
                g.setColor(Color.orange);
                g.drawRect(size.getActualX(x) - size.getActualWidth() / 2, size.getActualY(y), size.getActualWidth() + size.getActualWidth() / 2, size.getActualHeight());
            } else {
                g.drawRect(size.getActualX(x) - size.getActualWidth() / 2, size.getActualY(y), size.getActualWidth() + size.getActualWidth() / 2, size.getActualHeight());
                g.setColor(Color.orange);
                g.drawRect(size.getActualX(x), size.getActualY(y), size.getActualWidth() + size.getActualWidth() / 2, size.getActualHeight());
            }

            /// Damage size V2
            g.setColor(Color.green);
            if (animatePlayer.getAction().isFacingRight()) {
                g.drawRect(size.getActualX(x), size.getActualY(y), size.getActualWidth() + size.getDamageWidth(), size.getActualHeight());
            } else {
                g.drawRect(size.getActualX(x) - size.getDamageWidth(), size.getActualY(y), size.getActualWidth() + size.getDamageWidth(), size.getActualHeight());
            }
*/
        }
    }

    @Override
    public PlayerSizeInt getSize() {
        return size;
    }

    @Override
    public Skin getSkin() {
        return skin;
    }

    @Override
    public void setSkin(Skin skin) {
        this.skin = skin;
    }
}

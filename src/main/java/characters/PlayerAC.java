package characters;

import actions.AnimatePlayer;
import actions.imgsFactory.Skin;
import events.Events;
import utils.MyUtils;
import window.game.GameObject.ID;
import window.game.GameObject.MovingGameObject;

import java.awt.*;

public class PlayerAC extends MovingGameObject implements CharacterInt {
    private final String username;
    private final PlayerImage playerImage;
    private final AnimatePlayer animatePlayer;
    private int hp;
    private Skin skin;
    private boolean showDevSquare = false;

    public PlayerAC(int x, int y, ID id, int hp, String username, Skin skin) {
        super(x, y, id);     // TODO: x - size.removeWidth, y - size.removeHeight;
        this.hp = hp;
        this.username = username;
        this.skin = skin;

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
            g.drawRect(skin.getMiddleX(x), skin.getMiddleY(y), 1, 1);

            /// Image size
            MyUtils.drawRectDev(g, Color.gray, skin.getImgWH(), x, y);

            /// Actual image size
            MyUtils.drawRectDev(g, Color.white, skin.getActualImgWH(), x, y);

            /// Damage size
            MyUtils.drawRectDev(g, Color.red, skin.getDamageLeftWH(), x, y);
            MyUtils.drawRectDev(g, Color.orange, skin.getDamageRightWH(), x, y);
        }
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

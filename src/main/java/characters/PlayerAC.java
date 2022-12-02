package characters;

import actions.AnimatePlayer;
import actions.imgsFactory.Skin;
import events.Events;
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
    public void tick() {
        x += velX;
        y += velY;

        getAnimatePlayer().getAction().act();

        Events.checkWall(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(playerImage.getImg(), x, y, null);
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
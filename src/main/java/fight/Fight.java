package fight;

import characters.PlayerInterface;
import window.GameObject.GameObject;
import window.GameObject.ID;

import java.awt.*;

public class Fight extends GameObject {
    PlayerInterface player;
    PlayerInterface enemy;

    public Fight(int x, int y, ID id, PlayerInterface player, PlayerInterface enemy) {
        super(x, y, id);
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}

package characters;

import window.GameObject;
import window.ID;

import java.awt.*;

public class Player extends GameObject {

    int playerX;
    int playerY;
    int hp;

    public Player(int x, int y, ID id, int playerX, int playerY, int hp) {
        super(x, y, id);
        this.playerX = playerX;
        this.playerY = playerY;
        this.hp = hp;
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
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) g.setColor(Color.WHITE);
        else if (id == ID.Enemy) g.setColor(Color.RED);
        g.fillRect(x, y, playerX, playerY);
    }
}

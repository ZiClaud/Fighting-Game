package UI;

import characters.CharacterInt;
import window.GameObject.GameObject;
import window.GameObject.ID;

import java.awt.*;

public class HealthBar extends GameObject {
    CharacterInt player;

    public HealthBar(int x, int y, ID id, CharacterInt player) {
        super(x, y, id);
        this.player = player;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.HealthBarPlayer) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, player.getHp(), 10);
        } else if (id == ID.HealthBarEnemy) {
            g.setColor(Color.RED);
            g.fillRect(x, y, player.getHp(), 10);
        }
    }
}

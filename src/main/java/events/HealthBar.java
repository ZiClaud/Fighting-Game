package events;

import characters.CharacterInt;
import window.game.GameObject.GameObject;
import window.game.GameObject.ID;

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
        // TODO: Improve graphic
        if (id == ID.HealthBarPlayer) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, player.getHp() * 3 / 2, 13 * 3 / 2);
        } else if (id == ID.HealthBarEnemy) {
            g.setColor(Color.RED);
            g.fillRect(x - player.getHp() * 3 / 2, y, player.getHp() * 3 / 2, 13 * 3 / 2);
        }
    }
}

package events;

import characters.CharacterInt;
import window.game.GameObject.GameObject;
import window.game.GameObject.ID;

import java.awt.*;

public class HealthBar extends GameObject {
    CharacterInt player;
    private final int initialHp;

    public HealthBar(int x, int y, ID id, CharacterInt player) {
        super(x, y, id);
        this.player = player;
        this.initialHp = player.getHp();
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
            g.setColor(Color.BLACK);
            g.drawRect(x, y, initialHp * 3 / 2, 13 * 3 / 2);
            g.drawRect(x - 1, y - 1, initialHp * 3 / 2 + 2, 13 * 3 / 2 + 2);
        } else if (id == ID.HealthBarEnemy) {
            g.setColor(Color.RED);
            g.fillRect(x - player.getHp() * 3 / 2, y, player.getHp() * 3 / 2, 13 * 3 / 2);
            g.setColor(Color.BLACK);
            g.drawRect(x - initialHp * 3 / 2, y, initialHp * 3 / 2, 13 * 3 / 2);
            g.drawRect(x - initialHp * 3 / 2 - 1, y - 1, initialHp * 3 / 2 + 2, 13 * 3 / 2 + 2);
        }
    }
}

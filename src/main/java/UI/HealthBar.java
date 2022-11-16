package UI;

import characters.PlayerInterface;
import utils.Events;
import window.GameObject;
import window.GameObjectInt;
import window.ID;
import window.MyHandler;

import java.awt.*;

public class HealthBar extends GameObject {
    private final MyHandler handler;

    public HealthBar(int x, int y, ID id, MyHandler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        Events.ticketeTickete(handler);
    }

    @Override
    public void render(Graphics g) {
        for (GameObjectInt player : handler.objects) {
            if (id == ID.HealthBarPlayer) {
                g.setColor(Color.GREEN);
                if (player.getId() == ID.Player) {

                    g.fillRect(x, y, ((PlayerInterface) player).getHp(), 10);
                }
            } else if (id == ID.HealthBarEnemy) {
                g.setColor(Color.RED);
                if (player.getId() == ID.Enemy) {
                    g.fillRect(x, y, ((PlayerInterface) player).getHp(), 10);
                }
            }
        }
    }
}

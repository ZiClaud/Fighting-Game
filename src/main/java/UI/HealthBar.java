package UI;

import characters.Player;
import utils.Events;
import window.GameObject;
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
        for (GameObject player : handler.objects) {
            for (GameObject enemy : handler.objects) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    Events.collision((Player) player, (Player) enemy);
                }
            }

        }
    }

    @Override
    public void render(Graphics g) {

        for (GameObject player : handler.objects) {
            if (id == ID.HealthBarPlayer) {
                g.setColor(Color.GREEN);
                if (player.getId() == ID.Player) {

                    g.fillRect(x, y, ((Player) player).getHp(), 10);
                }
            } else if (id == ID.HealthBarEnemy){
                g.setColor(Color.RED);
                if (player.getId() == ID.Enemy) {
                    g.fillRect(x, y, ((Player) player).getHp(), 10);
                }
            }
        }
    }
}

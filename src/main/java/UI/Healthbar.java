package UI;

import characters.Player;
import window.GameObject;
import window.ID;
import window.MyHandler;

import java.awt.*;

public class Healthbar extends GameObject {
    private final MyHandler handler;

    public Healthbar(int x, int y, ID id, MyHandler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        for (GameObject player : handler.objects) {
            for (GameObject enemy : handler.objects) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    if (((Player) player).getSize().getActualX(player.getX()) >= enemy.getX()
                            /* ((Player) enemy).getSize().getActualLeftX(enemy.getX()) */
                            && ((Player) player).getSize().getActualRightX(player.getX()) <= enemy.getX()
                            /* ((Player) enemy).getSize().getActualRightX(enemy.getX()) */) {
                        if (((Player) player).getHp() < 0) {
                            System.out.println("Enemy won!"); // TODO: Print this in game

                            // TODO: Add countdown

                            // TODO: Reset HPs - FIX
                            ((Player) player).setHp(((Player) player).getHp() + 150);
                        }
                        ((Player) player).setHp(((Player) player).getHp() - 1);
                    }
                }
            }

        }
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.HealthBarPlayer) g.setColor(Color.GREEN);
        else if (id == ID.HealthBarEnemy) g.setColor(Color.RED);

        for (GameObject player : handler.objects) {
            if (player.getId() == ID.Player) {
                g.fillRect(x, y, ((Player) player).getHp(), 10);
            }
        }
    }
}

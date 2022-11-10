package UI;

import characters.Player;
import characters.PlayerAnimationType;
import window.Game;
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

    private void collision(Player player, Player enemy) {   // TODO: Put this somewhere else and make it public
        /*
        System.out.println("Player X: " + ((Player) player).getSize().getActualX(player.getX()) + ", " + ((Player) player).getSize().getActualRightX(player.getX()));
        System.out.println("Enemy X: " + ((Player) enemy).getSize().getActualX(enemy.getX()) + ", " + ((Player) enemy).getSize().getActualRightX(enemy.getX()));
        System.out.println("True/False: " + (((Player) player).getSize().getActualX(player.getX()) >= ((Player) enemy).getSize().getActualX(enemy.getX())) + ", " + (((Player) player).getSize().getActualRightX(player.getX()) <= ((Player) enemy).getSize().getActualRightX(enemy.getX())));
        */

        /// Check if they have the same X
        if (player.getSize().getActualX(player.getX()) <= enemy.getSize().getActualRightX(enemy.getX())
                && player.getSize().getActualRightX(player.getX()) >= enemy.getSize().getActualX(enemy.getX())) {
            /// Check if they have the same Y
            if (player.getSize().getActualY(player.getY()) <= enemy.getSize().getActualBottomY(enemy.getY())
                    && player.getSize().getActualBottomY(player.getY()) >= enemy.getSize().getActualY(enemy.getY())) {

                /**
                 * Hit taken
                 */
                player.getAction().setActionType(PlayerAnimationType.TakeHit);

                /**
                 * Death
                 */
                if (player.getHp() < 0) {
                    player.getAction().setActionType(PlayerAnimationType.Death);

                    System.out.println("Enemy won!"); // TODO: Print this in game

                    player.setX(50);
                    enemy.setX(Game.WIDTH - 50 - 163);
                    // TODO: Add countdown


                    // TODO: Reset HPs - FIX
                    player.setHp(player.getHp() + 100);
                }
                player.setHp(player.getHp() - 1);
            }
        }
    }

    @Override
    public void tick() {
        for (GameObject player : handler.objects) {
            for (GameObject enemy : handler.objects) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    collision((Player) player, (Player) enemy);
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

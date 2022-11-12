package UI;

import characters.Player;
import characters.PlayerAnimationType;
import characters.PlayerData;
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

    private void collision(PlayerData playerData, PlayerData enemyData) {   // TODO: Put this somewhere else and make it public
        /*
        System.out.println("Player X: " + ((Player) playerData).getSize().getActualX(playerData.getX()) + ", " + ((Player) playerData).getSize().getActualRightX(playerData.getX()));
        System.out.println("Enemy X: " + ((Player) enemyData).getSize().getActualX(enemyData.getX()) + ", " + ((Player) enemyData).getSize().getActualRightX(enemyData.getX()));
        System.out.println("True/False: " + (((Player) playerData).getSize().getActualX(playerData.getX()) >= ((Player) enemyData).getSize().getActualX(enemyData.getX())) + ", " + (((Player) playerData).getSize().getActualRightX(playerData.getX()) <= ((Player) enemyData).getSize().getActualRightX(enemyData.getX())));
        */

        /// Check if they have the same X
        if (playerData.getSize().getActualX(playerData.getPlayer().getX()) <= enemyData.getSize().getActualRightX(enemyData.getPlayer().getX())
                && playerData.getSize().getActualRightX(playerData.getPlayer().getX()) >= enemyData.getSize().getActualX(enemyData.getPlayer().getX())) {
            /// Check if they have the same Y
            if (playerData.getSize().getActualY(playerData.getPlayer().getY()) <= enemyData.getSize().getActualBottomY(enemyData.getPlayer().getY())
                    && playerData.getSize().getActualBottomY(playerData.getPlayer().getY()) >= enemyData.getSize().getActualY(enemyData.getPlayer().getY())) {

                /**
                 * Hit taken
                 */
                playerData.getAction().setActionType(PlayerAnimationType.TakeHit);

                /**
                 * Death
                 */
                if (playerData.getPlayer().getHp() < 0) {
                    playerData.getAction().setActionType(PlayerAnimationType.Death);

                    System.out.println("Enemy won!"); // TODO: Print this in game

                    playerData.getPlayer().setX(50);
                    enemyData.getPlayer().setX(Game.WIDTH - 50 - 163);

                    playerData.getPlayer().setY(Game.HEIGHT);
                    enemyData.getPlayer().setY(Game.HEIGHT);

                    // TODO: Add countdown


                    // TODO: Reset HPs - FIX
                    playerData.getPlayer().setHp(playerData.getPlayer().getHp() + 100);
                }
                playerData.getPlayer().setHp(playerData.getPlayer().getHp() - 1);
            }
        }
    }

    @Override
    public void tick() {
        for (GameObject player : handler.objects) {
            for (GameObject enemy : handler.objects) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    collision(((Player) player).getPlayerData(), ((Player) enemy).getPlayerData());
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

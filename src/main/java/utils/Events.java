package utils;

import actions.PlayerAction;
import characters.Player;
import window.Game;

public class Events {
    public static void collision(Player player, Player enemy) {   // TODO: Put this somewhere else and make it public
        /// Check if they have the same X
        if (player.getSize().getActualX(player.getX()) <= enemy.getSize().getActualRightX(enemy.getX())
                && player.getSize().getActualRightX(player.getX()) >= enemy.getSize().getActualX(enemy.getX())) {
            /// Check if they have the same Y
            if (player.getSize().getActualY(player.getY()) <= enemy.getSize().getActualBottomY(enemy.getY())
                    && player.getSize().getActualBottomY(player.getY()) >= enemy.getSize().getActualY(enemy.getY())) {
                //TODO: Collision effect
                takeHit(player, enemy);
            }
        }
    }

    public static void jump(Player player) {

    }

    public static void fall(Player player) {

    }

    public static void takeHit(Player player, Player enemy) {
        /**
         * Hit taken
         */
        player.getAction().setActionType(PlayerAction.TakeHit);

        death(player, enemy);
        player.setHp(player.getHp() - 1);
    }

    public static void death(Player player, Player enemy) {
        /**
         * Death
         */
        if (player.getHp() < 0) {
            player.getAction().setActionType(PlayerAction.Death);

            System.out.println("Enemy won!"); // TODO: Print this in game

            player.setX(50);
            enemy.setX(Game.WIDTH - 50 - 163);

            player.setY(Game.HEIGHT);
            enemy.setY(Game.HEIGHT);

            // TODO: Add countdown


            // TODO: Reset HPs - FIX
            player.setHp(player.getHp() + 100);
        }
    }
}

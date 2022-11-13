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

    public static void hit(Player hitter, Player hitten) {
        hitter.getAction().setActionType(PlayerAction.Attack1);
        takeHit(hitten, hitter);
    }

    public static void takeHit(Player hitten, Player hitter) {
        /**
         * Hit taken
         */
        hitten.getAction().setActionType(PlayerAction.TakeHit);
        hitten.setHp(hitten.getHp() - 1);

        if (hitten.getHp() < 0) {
            death(hitten, hitter);
        }
    }

    public static void death(Player loser, Player winner) {
        /**
         * Death
         */
        loser.getAction().setActionType(PlayerAction.Death);

        System.out.println(winner.getUsername() + " won!"); // TODO: Print this in game

        loser.setX(50);
        winner.setX(Game.WIDTH - 50 - 163);

        loser.setY(Game.HEIGHT);
        winner.setY(Game.HEIGHT);

        // TODO: Add countdown

        // TODO: Reset HPs - FIX

        loser.setHp(loser.getHp() + 100);
    }
}

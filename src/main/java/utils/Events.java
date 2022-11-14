package utils;

import actions.PlayerAction;
import characters.PlayerInterface;
import window.Game;
import window.ID;

public class Events {   //TODO: Change class -> Maybe not static, maybe with just "Player" as argument, idk
    public static void checkWall(PlayerInterface player) {
        /**
         * Right/Left Wall
         */
        if (player.getSize().getActualX(player.getX()) <= 0 || player.getSize().getActualRightX(player.getX()) >= Game.WIDTH) {
            player.setVelX(0);
            if (player.getSize().getActualX(player.getX()) <= 0) {
                player.setX(-player.getSize().getExcessiveLeft());
            } else if (player.getSize().getActualRightX(player.getX()) >= Game.WIDTH) {
                player.setX(Game.WIDTH - player.getSize().getImgWidth() + player.getSize().getExcessiveRight());
            }
        }
        /**
         * Top/Bottom Wall
         */
        if (player.getSize().getActualY(player.getY()) <= 0 || player.getSize().getActualBottomY(player.getY()) >= Game.HEIGHT) {
            player.setVelY(0);
            if (player.getSize().getActualY(player.getY()) <= 0) {
                player.setY(-player.getSize().getExcessiveTop());
            } else if (player.getSize().getActualBottomY(player.getY()) >= Game.HEIGHT) {
                player.setY(Game.HEIGHT - player.getSize().getImgHeight() + player.getSize().getExcessiveBottom());
            }
        }
    }

    public static void collision(PlayerInterface player, PlayerInterface enemy) {   // TODO: Put this somewhere else and make it public
        /// Check if they have the same X
        if (player.getSize().getActualX(player.getX()) <= enemy.getSize().getActualRightX(enemy.getX())
                && player.getSize().getActualRightX(player.getX()) >= enemy.getSize().getActualX(enemy.getX())) {
            /// Check if they have the same Y
            if (player.getSize().getActualY(player.getY()) <= enemy.getSize().getActualBottomY(enemy.getY())
                    && player.getSize().getActualBottomY(player.getY()) >= enemy.getSize().getActualY(enemy.getY())) {
                //TODO: Collision effect

                // TODO: Understand why this works
                if (player.getAction().getActionType() == PlayerAction.Attack1)
                    hit(player, enemy);
                if (enemy.getAction().getActionType() == PlayerAction.Attack1)
                    hit(enemy, player);
            }
        }
    }

    public static void jump(PlayerInterface player) {

    }

    public static void fall(PlayerInterface player) {

    }

    public static void hit(PlayerInterface hitter, PlayerInterface damaged) {
        // TODO: hitter will now attack when he touches damaged - TO FIX
        hitter.getAction().setActionType(PlayerAction.Attack1);
        takeHit(damaged, hitter);
    }

    private static void takeHit(PlayerInterface damaged, PlayerInterface hitter) {
        /**
         * Hit taken
         */
        damaged.getAction().setActionType(PlayerAction.TakeHit);
        damaged.setHp(damaged.getHp() - 1);

        if (damaged.getHp() < 0) {
            death(damaged, hitter);
        }
    }

    private static void death(PlayerInterface loser, PlayerInterface winner) {
        /**
         * Death
         */
        loser.getAction().setActionType(PlayerAction.Death);

        System.out.println(winner.getUsername() + " won!"); // TODO: Print this in game

        // Reset location
        if (winner.getId() == ID.Player) {
            winner.setX(50);
            loser.setX(Game.WIDTH - 50 - 163);
        } else {
            loser.setX(50);
            winner.setX(Game.WIDTH - 50 - 163);
        }
        winner.setY(Game.HEIGHT);
        loser.setY(Game.HEIGHT);

        // TODO: Add countdown

        // TODO: Reset HPs - FIX

        loser.setHp(loser.getHp() + 100);
    }
}

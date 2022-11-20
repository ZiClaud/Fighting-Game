package utils;

import actions.PlayerAction;
import characters.PlayerInterface;
import window.Game;
import window.GameObject.GameObjectInt;
import window.GameObject.ID;
import window.MyHandler;

import static window.Game.HEIGHT_WINDOW;

public class Events {   //TODO: Change class -> Maybe not static, maybe with just "Player" as argument, idk
    public static void ticketeTickete(MyHandler handler) {
        for (GameObjectInt player : handler.getObjects()) {
            if (player.getId() == ID.Player || player.getId() == ID.Enemy) {
                /**
                 * Fall
                 */
                if (((PlayerInterface) player).getSize().getActualBottomY(player.getY()) != HEIGHT_WINDOW) {
                    Events.fall((PlayerInterface) player);
                }
            }
        }

        /**
         * Collision
         */
        for (GameObjectInt player : handler.getObjects()) {
            for (GameObjectInt enemy : handler.getObjects()) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    Events.collision((PlayerInterface) player, (PlayerInterface) enemy);
                }
            }
        }
    }

    public static void event(PlayerInterface player, int i) {   // TODO: Use wisely - Works when frame of player is indeed the sword attacking
        if (player.getId() == ID.Player) {
            if (player.getAction().getActionType() == PlayerAction.Attack1 && i == 5) {
                System.out.println("Attack1! by player");
//              Events.hit();
            }
        } else if (player.getId() == ID.Enemy) {
            if (player.getAction().getActionType() == PlayerAction.Attack1 && i == 3) {
                System.out.println("Attack1! by enemy");
//              Events.hit();
            }
        }
    }

    public static void checkWall(PlayerInterface player) {
        /**
         * Right/Left Wall
         */
        if (player.getSize().getActualX(player.getX()) <= 0 || player.getSize().getActualRightX(player.getX()) >= Game.WIDTH_WINDOW) {
            player.setVelX(0);
            if (player.getSize().getActualX(player.getX()) <= 0) {
                player.setX(-player.getSize().getExcessiveLeft());
            } else if (player.getSize().getActualRightX(player.getX()) >= Game.WIDTH_WINDOW) {
                player.setX(Game.WIDTH_WINDOW - player.getSize().getImgWidth() + player.getSize().getExcessiveRight());
            }
        }
        /**
         * Top/Bottom Wall
         */
        if (player.getSize().getActualY(player.getY()) <= 0 || player.getSize().getActualBottomY(player.getY()) >= Game.HEIGHT_WINDOW) {
            player.setVelY(0);
            if (player.getSize().getActualY(player.getY()) <= 0) {
                player.setY(-player.getSize().getExcessiveTop());
            } else if (player.getSize().getActualBottomY(player.getY()) >= Game.HEIGHT_WINDOW) {
                player.setY(Game.HEIGHT_WINDOW - player.getSize().getImgHeight() + player.getSize().getExcessiveBottom());
            }
        }
    }

    public static void collision(PlayerInterface player, PlayerInterface enemy) {   // TODO: Put this somewhere else and make it public
        boolean isPlayerLeftEnemyRight = player.getSize().getActualX(player.getX()) <= enemy.getSize().getActualRightX(enemy.getX());
        boolean isPlayerRightEnemyLeft = player.getSize().getActualRightX(player.getX()) >= enemy.getSize().getActualX(enemy.getX());
        boolean isPlayerTopEnemyBottom = player.getSize().getActualY(player.getY()) <= enemy.getSize().getActualBottomY(enemy.getY());
        boolean isPlayerBottomEnemyTop = player.getSize().getActualBottomY(player.getY()) >= enemy.getSize().getActualY(enemy.getY());
        //System.out.println("isPlayerLeftEnemyRight? " + isPlayerLeftEnemyRight);
        //System.out.println("isPlayerRightEnemyLeft? " + isPlayerRightEnemyLeft);
        //System.out.println("isPlayerBottomEnemyTop? " + isPlayerBottomEnemyTop);

        /// Check if they have the same X
        if (isPlayerLeftEnemyRight && isPlayerRightEnemyLeft) {
            /// Check if they have the same Y
            if (isPlayerTopEnemyBottom && isPlayerBottomEnemyTop) {
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
        // TODO: Understand why this doesn't work - it's bugged
//        player.getAction().setActionType(PlayerAction.Fall);
//        player.getAnimatePlayer().update(PlayerAction.Fall);
    }

    public static void hit(PlayerInterface hitter, PlayerInterface damaged) {
        // TODO: hitter will now attack when he touches damaged - TO FIX
        //       hitter.getAction().setActionType(PlayerAction.Attack1);
        hitter.getAnimatePlayer().update(PlayerAction.Attack1);
        _takeHit(damaged, hitter);
    }

    private static void _takeHit(PlayerInterface damaged, PlayerInterface hitter) {
        /**
         * Hit taken
         */
        //     damaged.getAction().setActionType(PlayerAction.TakeHit);
        damaged.getAnimatePlayer().update(PlayerAction.TakeHit);
        damaged.setHp(damaged.getHp() - 1);

        if (damaged.getHp() < 0) {
            _death(damaged, hitter);
        }
    }

    private static void _death(PlayerInterface loser, PlayerInterface winner) {
        /**
         * Death
         */
        //       loser.getAction().setActionType(PlayerAction.Death);
        loser.getAnimatePlayer().update(PlayerAction.Death);

        // TODO: Print this in game
        System.out.println(winner.getUsername() + " won!");

        // TODO: use method that makes Handler remove objects and re-add them - resetHandlerObjects() in Game
        // Reset game
        if (winner.getId() == ID.Player) {
            winner.setX(50);
            loser.setX(Game.WIDTH_WINDOW - 50 - 163);
        } else {
            loser.setX(50);
            winner.setX(Game.WIDTH_WINDOW - 50 - 163);
        }
        winner.setY(Game.HEIGHT_WINDOW);
        loser.setY(Game.HEIGHT_WINDOW);

        // TODO: Add countdown

        loser.setHp(loser.getHp() + 100);
    }
}

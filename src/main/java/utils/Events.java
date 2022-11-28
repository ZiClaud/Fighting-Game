package utils;

import actions.ActionType;
import characters.CharacterInt;
import window.game.Game;
import window.game.GameObject.GameObjectInt;
import window.game.GameObject.ID;
import window.game.MyHandler;

import static window.game.Game.HEIGHT_WINDOW;

public class Events {   //TODO: Change class -> Maybe not static, maybe with just "Player" as argument, idk
    private static int fallingSpeed;

    public static void ticketeTickete(MyHandler handler) {
        for (GameObjectInt player : handler.getObjects()) {
            if (player.getId() == ID.Player || player.getId() == ID.Enemy) {
                /**
                 * Jump
                 */
                jump((CharacterInt) player);

                stopCharacter((CharacterInt) player);
            }
        }

        /**
         * Collision
         */
        for (GameObjectInt player : handler.getObjects()) {
            for (GameObjectInt enemy : handler.getObjects()) {
                if (player.getId() == ID.Player && enemy.getId() == ID.Enemy) {
                    Events.collision((CharacterInt) player, (CharacterInt) enemy);
                    Events.attack((CharacterInt) player, (CharacterInt) enemy);
                }
            }
        }
    }

    public static void animationEvent(CharacterInt character, int animationFrame) {   // TODO: Use wisely - Works when frame of player is indeed the sword attacking
        if (character.getId() == ID.Player || character.getId() == ID.Enemy) {
            if (animationFrame == 2 && character.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1) {
//                System.out.println("Attack1! by " + character.getUsername());
//              Events.hit();
            } else if (animationFrame == 3 && character.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1) {
//                System.out.println("Attack1! by " + character.getUsername() + " completed");
                character.getAnimatePlayer().removePlayerAction(ActionType.Attack1);
            } else if (animationFrame == 6 && character.getAnimatePlayer().getAction().getBestActionType() == ActionType.Death) {
//                System.out.println("Death by " + character.getUsername());
                character.getAnimatePlayer().removePlayerAction(ActionType.Death);
                character.getAnimatePlayer().removePlayerAction(ActionType.TakeHit);
                character.getAnimatePlayer().removePlayerAction(ActionType.TakeHitC);
            } else if (animationFrame == 4 && (character.getAnimatePlayer().getAction().getBestActionType() == ActionType.TakeHit || character.getAnimatePlayer().getAction().getBestActionType() == ActionType.TakeHit)) {
//                System.out.println(character.getUsername() + " Damaged");
                character.getAnimatePlayer().removePlayerAction(ActionType.TakeHit);
                character.getAnimatePlayer().removePlayerAction(ActionType.TakeHitC);
            }
        }
    }

    public static void checkWall(CharacterInt player) {
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

    public static void collision(CharacterInt player, CharacterInt enemy) {
        int playerCenter = player.getSize().getActualX(player.getX()) + player.getSize().getActualWidth() / 2;
        int enemyCenter = enemy.getSize().getActualX(enemy.getX()) + enemy.getSize().getActualWidth() / 2;

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
                /// Collision effect
                if (player.getSize().getActualX(player.getX()) + (player.getSize().getActualWidth() / 2) <=
                        enemy.getSize().getActualRightX(enemy.getX()) + enemy.getSize().getActualWidth() / 2) {
                    if (playerCenter < enemyCenter) {
                        player.setX(player.getX() - 4);
                        enemy.setX(enemy.getX() + 4);
                    } else {
                        player.setX(player.getX() + 4);
                        enemy.setX(enemy.getX() - 4);
                    }
                }
            }
        }
    }

    public static void attack(CharacterInt player, CharacterInt enemy) {
        int playerHalfWidth = (player.getSize().getActualWidth() / 2);
        int enemyHalfWidth = (enemy.getSize().getActualWidth() / 2);

        int playerCenter = player.getSize().getMiddleX(player.getX());
        int enemyCenter = enemy.getSize().getMiddleX(enemy.getX());


        boolean isPlayerLeftEnemyRight = player.getSize().getActualX(player.getX()) - playerHalfWidth <= enemy.getSize().getActualRightX(enemy.getX()) + enemyHalfWidth;
        boolean isPlayerRightEnemyLeft = player.getSize().getActualRightX(player.getX()) + playerHalfWidth >= enemy.getSize().getActualX(enemy.getX()) - enemyHalfWidth;
        boolean isPlayerTopEnemyBottom = player.getSize().getActualY(player.getY()) <= enemy.getSize().getActualBottomY(enemy.getY());
        boolean isPlayerBottomEnemyTop = player.getSize().getActualBottomY(player.getY()) >= enemy.getSize().getActualY(enemy.getY());

        //System.out.println("isPlayerLeftEnemyRight? " + isPlayerLeftEnemyRight);
        //System.out.println("isPlayerRightEnemyLeft? " + isPlayerRightEnemyLeft);
        //System.out.println("isPlayerBottomEnemyTop? " + isPlayerBottomEnemyTop);

        /// Check if they have the same X
        if (isPlayerLeftEnemyRight && isPlayerRightEnemyLeft) {
            /// Check if they have the same Y
            if (isPlayerTopEnemyBottom && isPlayerBottomEnemyTop) {
                if ((player.getAnimatePlayer().getAction().isFacingRight() && playerCenter < enemyCenter) ||
                        (!player.getAnimatePlayer().getAction().isFacingRight() && playerCenter > enemyCenter)) {
                    // TODO: Understand why this works
                    if (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1)
                        hit(player, enemy);
                }
                if ((enemy.getAnimatePlayer().getAction().isFacingRight() && enemyCenter < playerCenter) ||
                        (!enemy.getAnimatePlayer().getAction().isFacingRight() && enemyCenter > playerCenter)) {
                    if (enemy.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1)
                        hit(enemy, player);
                }
            }
        }
    }

    private static void stopCharacter(CharacterInt player) {
        if (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.TakeHit ||
                player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Death) {
            player.setVelX(0);
            player.setVelY(0);
        }
    }

    private static void jump(CharacterInt player) {
        if (isOnGround(player)) {
            if (isJumping(player)) {
                int JUMP_POWER = -5;
                fallingSpeed = JUMP_POWER;

                player.setVelY(player.getVelY() + JUMP_POWER);

                player.getAnimatePlayer().addPlayerAction(ActionType.Jump);

            } else {
                if (isFalling(player)) {
                    player.getAnimatePlayer().removePlayerAction(ActionType.Fall);
                }
            }
        } else {
            /**
             * Fall
             */
            fall(player);
        }
    }

    private static void fall(CharacterInt player) {
        int GRAVITY = 1;
        fallingSpeed += GRAVITY;

        if (fallingSpeed == 0) {
            player.getAnimatePlayer().removePlayerAction(ActionType.Jump);
        }

        player.setVelY(player.getVelY() + fallingSpeed);

        player.getAnimatePlayer().addPlayerAction(ActionType.Fall);
    }

    private static boolean isOnGround(CharacterInt player) {
        return player.getSize().getActualBottomY(player.getY()) >= HEIGHT_WINDOW;
    }


    private static boolean isJumping(CharacterInt player) {
        return (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Jump);
    }

    private static boolean isFalling(CharacterInt player) {
        return (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Fall);
    }

    public static void hit(CharacterInt hitter, CharacterInt damaged) {
        // TODO: hitter will now attack when he touches damaged - TO FIX
        //       hitter.getAction().setActionType(PlayerAction.Attack1);
        hitter.getAnimatePlayer().addPlayerAction(ActionType.Attack1);
        _takeHit(damaged, hitter);
    }

    private static void _takeHit(CharacterInt damaged, CharacterInt hitter) {
        /**
         * Hit taken
         */
        //     damaged.getAction().setActionType(PlayerAction.TakeHit);
        damaged.getAnimatePlayer().addPlayerAction(ActionType.TakeHit);
        damaged.setHp(damaged.getHp() - 1);

        if (damaged.getHp() < 0) {
            _death(damaged, hitter);
        }
    }

    private static void _death(CharacterInt loser, CharacterInt winner) {
        /**
         * Death
         */
        //       loser.getAction().setActionType(PlayerAction.Death);
        loser.getAnimatePlayer().addPlayerAction(ActionType.Death);

        // TODO: Print this in game
        System.out.println(winner.getUsername() + " won!");

        // TODO: Wait until the "death" animation is over, then restart the game

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

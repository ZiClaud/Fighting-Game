package events;

import actions.ActionType;
import characters.CharacterInt;
import utils.MyUtils;
import window.UI.MenuWindow;
import window.game.Game;
import window.game.GameObject.GameObjectInt;
import window.game.GameObject.ID;
import window.game.MyHandler;

import javax.swing.*;

import static window.game.Game.HEIGHT_WINDOW;
import static window.game.Game.WIDTH_WINDOW;

public class Events {   //TODO: Change class -> Maybe not static, maybe with just "Player" as argument, idk
    private static int fallingSpeed;
    private static Game game;
    private static JFrame frame;
    private static boolean playerWon = false;
    private static boolean enemyWon = false;

    public static void setGame(Game game, JFrame frame) {
        Events.game = game;
        Events.frame = frame;
    }

    public static void ticketeTickete(MyHandler handler) {
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
        if (player.getSkin().getActualImgWH().getX(player.getX()) <= 0 || player.getSkin().getActualImgWH().getXPlusWidth(player.getX()) >= WIDTH_WINDOW) {
            player.setVelX(0);
            if (player.getSkin().getActualImgWH().getX(player.getX()) <= 0) {
                player.setX(-player.getSkin().getExcessiveLeft());
            } else if (player.getSkin().getActualImgWH().getXPlusWidth(player.getX()) >= WIDTH_WINDOW) {
                player.setX(WIDTH_WINDOW - player.getSkin().getImgWH().getWidth() + player.getSkin().getExcessiveRight());
            }
        }

        /**
         * Top/Bottom Wall
         */
        if (player.getSkin().getActualImgWH().getY(player.getY()) <= 0 || player.getSkin().getActualImgWH().getYPlusHeight(player.getY()) >= HEIGHT_WINDOW) {
            player.setVelY(0);
            if (player.getSkin().getActualImgWH().getY(player.getY()) <= 0) {
                player.setY(-player.getSkin().getExcessiveTop());
            } else if (player.getSkin().getActualImgWH().getYPlusHeight(player.getY()) >= HEIGHT_WINDOW) {
                player.setY(HEIGHT_WINDOW - player.getSkin().getImgWH().getHeight() + player.getSkin().getExcessiveBottom());
            }
        }
    }

    public static void collision(CharacterInt player, CharacterInt enemy) {
        if (MyUtils.collideWH(player.getSkin().getActualImgWH(), player, enemy.getSkin().getActualImgWH(), enemy)) {
            /// Collision effect
            if (player.getSkin().getActualImgWH().getX(player.getX()) + (player.getSkin().getActualImgWH().getWidth() / 2) <=
                    enemy.getSkin().getActualImgWH().getXPlusWidth(enemy.getX()) + enemy.getSkin().getActualImgWH().getWidth() / 2) {
                if (player.getSkin().getMiddleX(player.getX()) < enemy.getSkin().getMiddleX(enemy.getX())) {
                    player.setX(player.getX() - 5);
                    enemy.setX(enemy.getX() + 5);
                } else {
                    player.setX(player.getX() + 5);
                    enemy.setX(enemy.getX() - 5);
                }
            }
        }
    }

    public static void attack(CharacterInt player, CharacterInt enemy) {
        if (isXInAttackRange(player, enemy)) {
            if (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1)
                hit(player, enemy);
        }
        if (isXInAttackRange(enemy, player)) {
            if (enemy.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1)
                hit(enemy, player);
        }
    }

    public static boolean isXInAttackRange(CharacterInt playerX, CharacterInt playerY) {
        if (playerX.getAnimatePlayer().getAction().isFacingRight()) {
            return MyUtils.collideWH(playerX.getSkin().getDamageLeftWH(), playerX, playerY.getSkin().getActualImgWH(), playerY);
        } else {
            return MyUtils.collideWH(playerX.getSkin().getDamageRightWH(), playerX, playerY.getSkin().getActualImgWH(), playerY);
        }
    }

    public static void stopCharacter(CharacterInt player) {
        if (player.getAnimatePlayer().getAction().getBestActionType() == ActionType.TakeHit ||
                player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Death ||
                player.getAnimatePlayer().getAction().getBestActionType() == ActionType.Attack1) {
            player.setVelX(0);
            player.setVelY(0);
        }
    }

    public static void jump(CharacterInt player) {
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
        return player.getSkin().getActualImgWH().getYPlusHeight(player.getY()) >= HEIGHT_WINDOW;
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
        _knockback(damaged, hitter);

        if (damaged.getHp() < 0) {
            _death(damaged, hitter);
        }
    }

    private static void _knockback(CharacterInt damaged, CharacterInt hitter) {
        if (damaged.getSkin().getMiddleX(damaged.getX()) >= hitter.getSkin().getMiddleX(hitter.getX())) {
            // If damaged is on right
            damaged.setVelX(2);
        } else {
            // If damaged is on left
            damaged.setVelX(-2);
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
        winner.setY(HEIGHT_WINDOW);
        loser.setY(HEIGHT_WINDOW);

        // TODO: Add countdown

        loser.setHp(loser.getHp() + 100);

        if (loser.getId() == ID.Player) {
            if (enemyWon) {
                endGame();
            } else {
                enemyWon = true;
            }
        } else if (loser.getId() == ID.Enemy) {
            if (playerWon) {
                endGame();
            } else {
                playerWon = true;
            }
        }
    }

    private static void endGame() {
        playerWon = false;
        enemyWon = false;
        new MenuWindow();
        frame.setVisible(false);
        game.stop();
    }
}

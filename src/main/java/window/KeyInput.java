package window;

import actions.PlayerAction;
import characters.CharacterInt;
import characters.ObserverAnimation;
import window.GameObject.ID;
import window.GameObject.MovingGameObjectInt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private final MyHandler handler;

    public KeyInput(MyHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (MovingGameObjectInt tempObject : handler.getOnlyMovingObjects()) {
            if (tempObject.getId() == ID.Player) {
                ObserverAnimation playerObserverAnimation = ((CharacterInt) tempObject).getAnimatePlayer();

                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
//                    tempObject.setVelY(-5);
                    playerObserverAnimation.update(PlayerAction.Jump);
                }
                if (key == KeyEvent.VK_S) {
//                    tempObject.setVelY(5);
//                    playerObserverAnimation.update(PlayerAction.Fall);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    playerObserverAnimation.update(PlayerAction.Run, false);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    playerObserverAnimation.update(PlayerAction.Run, true);
                }
                if (key == KeyEvent.VK_SPACE) {
//                    System.out.println("Attack! Or jump, idk yet");
                    playerObserverAnimation.update(PlayerAction.Attack1);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                ObserverAnimation enemyObserverAnimation = ((CharacterInt) tempObject).getAnimatePlayer();
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
//                    tempObject.setVelY(-5);
                    enemyObserverAnimation.update(PlayerAction.Jump);
                }
                if (key == KeyEvent.VK_DOWN) {
//                    tempObject.setVelY(5);
//                    enemyObserverAnimation.update(PlayerAction.Fall);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-5);
                    enemyObserverAnimation.update(PlayerAction.Run, false);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(5);
                    enemyObserverAnimation.update(PlayerAction.Run, true);
                }
                if (key == KeyEvent.VK_ENTER) {
                    enemyObserverAnimation.update(PlayerAction.Attack1);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (MovingGameObjectInt tempObject : handler.getOnlyMovingObjects()) {
            if (tempObject.getId() == ID.Player) {
                ObserverAnimation playerObserverAnimation = ((CharacterInt) tempObject).getAnimatePlayer();
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                    playerObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                    tempObject.setVelX(0);
                    playerObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_SPACE) {
                    playerObserverAnimation.update(PlayerAction.Idle);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                ObserverAnimation enemyObserverAnimation = ((CharacterInt) tempObject).getAnimatePlayer();
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(0);
                    enemyObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(0);
                    enemyObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(0);
                    enemyObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(0);
                    enemyObserverAnimation.update(PlayerAction.Idle);
                }
                if (key == KeyEvent.VK_ENTER) {
                    enemyObserverAnimation.update(PlayerAction.Idle);
                }
            }
        }
    }
}

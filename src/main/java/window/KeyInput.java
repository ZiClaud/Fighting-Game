package window;

import actions.ActionType;
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
            CharacterInt character = ((CharacterInt) tempObject);
            ObserverAnimation observerAnimation = character.getAnimatePlayer();

            if (tempObject.getId() == ID.Player) {

                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
                    pressedW(observerAnimation);
                }
                if (key == KeyEvent.VK_S) {
                    pressedS(observerAnimation);
                }
                if (key == KeyEvent.VK_A) {
                    pressedA(observerAnimation, character);
                }
                if (key == KeyEvent.VK_D) {
                    pressedD(observerAnimation, character);
                }
                if (key == KeyEvent.VK_SPACE) {
                    pressedSpace(observerAnimation);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    pressedW(observerAnimation);
//                    tempObject.setVelY(-5);
////                    observerAnimation.addPlayerAction(ActionType.Jump);
                }
                if (key == KeyEvent.VK_DOWN) {
                    pressedS(observerAnimation);
//                    tempObject.setVelY(5);
//                    enemyObserverAnimation.update(PlayerAction.Fall);
                }
                if (key == KeyEvent.VK_LEFT) {
                    pressedA(observerAnimation, character);
////                    tempObject.setVelX(-5);
////                    observerAnimation.addPlayerAction(ActionType.Run, false);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    pressedD(observerAnimation, character);
////                    tempObject.setVelX(5);
////                    observerAnimation.addPlayerAction(ActionType.Run, true);
                }
                if (key == KeyEvent.VK_ENTER) {
                    pressedSpace(observerAnimation);
////                    observerAnimation.addPlayerAction(ActionType.Attack1);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (MovingGameObjectInt tempObject : handler.getOnlyMovingObjects()) {
            CharacterInt character = ((CharacterInt) tempObject);
            ObserverAnimation observerAnimation = ((CharacterInt) tempObject).getAnimatePlayer();

            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
                    releasedW(observerAnimation);
                }
                if (key == KeyEvent.VK_S) {
                    releasedS(observerAnimation);
                }
                if (key == KeyEvent.VK_A) {
                    releasedA(observerAnimation, character);
                }
                if (key == KeyEvent.VK_D) {
                    releasedD(observerAnimation, character);
                }
                if (key == KeyEvent.VK_SPACE) {
                    releasedSpace(observerAnimation);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    releasedW(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Jump);
                }
                if (key == KeyEvent.VK_DOWN) {
                    releasedS(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Fall);
                }
                if (key == KeyEvent.VK_LEFT) {
                    releasedA(observerAnimation, character);
////                    tempObject.setVelX(0);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Run);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    releasedD(observerAnimation, character);
////                    tempObject.setVelX(0);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Run);
                }
                if (key == KeyEvent.VK_ENTER) {
                    releasedSpace(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Attack1);
                }
            }
        }
    }

    private void pressedW(ObserverAnimation playerObserverAnimation) {
//                    tempObject.setVelY(-5);
        playerObserverAnimation.addPlayerAction(ActionType.Jump);
    }

    private void pressedS(ObserverAnimation playerObserverAnimation) {
//                    tempObject.setVelY(5);
//                    playerObserverAnimation.update(PlayerAction.Fall);
    }

    private void pressedA(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(-5);
        playerObserverAnimation.addPlayerAction(ActionType.Run, false);
    }

    private void pressedD(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(5);
        playerObserverAnimation.addPlayerAction(ActionType.Run, true);
    }

    private void pressedSpace(ObserverAnimation playerObserverAnimation) {
        //                    System.out.println("Attack! Or jump, idk yet");
        playerObserverAnimation.addPlayerAction(ActionType.Attack1);
    }

    private void releasedW(ObserverAnimation playerObserverAnimation) {
        // TODO: CHECK IF IT'S OK -- FIX --
        playerObserverAnimation.removePlayerAction(ActionType.Jump);
    }

    private void releasedS(ObserverAnimation playerObserverAnimation) {
        // TODO: CHECK IF IT'S OK
//        playerObserverAnimation.removePlayerAction(ActionType.Fall);
    }

    private void releasedA(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(0);
        // TODO: CHECK IF IT'S OK
        playerObserverAnimation.removePlayerAction(ActionType.Run);

    }

    private void releasedD(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(0);
        // TODO: CHECK IF IT'S OK
        playerObserverAnimation.removePlayerAction(ActionType.Run);
    }

    private void releasedSpace(ObserverAnimation playerObserverAnimation) {
    }


}

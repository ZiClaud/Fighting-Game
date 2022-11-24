package window;

import characters.CharacterInt;
import characters.ObserverAnimation;
import window.GameObject.GameObjectInt;
import window.GameObject.ID;
import window.GameObject.MovingGameObjectInt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private final MyHandler handler;
    private boolean isAIHere = false;

    public KeyInput(MyHandler handler) {
        this.handler = handler;
    }

    public void checkIfAIIsHere(){
        for (GameObjectInt tempObject : handler.getObjects()){
            if (tempObject.getId() == ID.AI){
                this.isAIHere = true;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (MovingGameObjectInt tempObject : handler.getOnlyMovingObjects()) {
            CharacterInt character = ((CharacterInt) tempObject);
            ObserverAnimation observerAnimation = character.getAnimatePlayer();

            if (tempObject.getId() == ID.Player) {

                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
                    KeyPressed.pressedW(observerAnimation);
                }
                if (key == KeyEvent.VK_S) {
                    KeyPressed.pressedS(observerAnimation);
                }
                if (key == KeyEvent.VK_A) {
                    KeyPressed.pressedA(observerAnimation, character);
                }
                if (key == KeyEvent.VK_D) {
                    KeyPressed.pressedD(observerAnimation, character);
                }
                if (key == KeyEvent.VK_SPACE) {
                    KeyPressed.pressedSpace(observerAnimation);
                }
            }

            if (tempObject.getId() == ID.Enemy && !isAIHere) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    KeyPressed.pressedW(observerAnimation);
//                    tempObject.setVelY(-5);
////                    observerAnimation.addPlayerAction(ActionType.Jump);
                }
                if (key == KeyEvent.VK_DOWN) {
                    KeyPressed.pressedS(observerAnimation);
//                    tempObject.setVelY(5);
//                    enemyObserverAnimation.update(PlayerAction.Fall);
                }
                if (key == KeyEvent.VK_LEFT) {
                    KeyPressed.pressedA(observerAnimation, character);
////                    tempObject.setVelX(-5);
////                    observerAnimation.addPlayerAction(ActionType.Run, false);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    KeyPressed.pressedD(observerAnimation, character);
////                    tempObject.setVelX(5);
////                    observerAnimation.addPlayerAction(ActionType.Run, true);
                }
                if (key == KeyEvent.VK_ENTER) {
                    KeyPressed.pressedSpace(observerAnimation);
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
                    KeyPressed.releasedW(observerAnimation);
                }
                if (key == KeyEvent.VK_S) {
                    KeyPressed.releasedS(observerAnimation);
                }
                if (key == KeyEvent.VK_A) {
                    KeyPressed.releasedA(observerAnimation, character);
                }
                if (key == KeyEvent.VK_D) {
                    KeyPressed.releasedD(observerAnimation, character);
                }
                if (key == KeyEvent.VK_SPACE) {
                    KeyPressed.releasedSpace(observerAnimation);
                }
            }

            if (tempObject.getId() == ID.Enemy && !isAIHere) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    KeyPressed.releasedW(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Jump);
                }
                if (key == KeyEvent.VK_DOWN) {
                    KeyPressed.releasedS(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Fall);
                }
                if (key == KeyEvent.VK_LEFT) {
                    KeyPressed.releasedA(observerAnimation, character);
////                    tempObject.setVelX(0);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Run);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    KeyPressed.releasedD(observerAnimation, character);
////                    tempObject.setVelX(0);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Run);
                }
                if (key == KeyEvent.VK_ENTER) {
                    KeyPressed.releasedSpace(observerAnimation);
////                    enemyObserverAnimation.removePlayerAction(ActionType.Attack1);
                }
            }
        }
    }
}

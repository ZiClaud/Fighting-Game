package window;

import characters.PlayerInterface;
import actions.PlayerActions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final MyHandler handler;

    public KeyInput(MyHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObjectInt tempObject : handler.objects) {
            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Jump);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);

                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Fall);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Run);
                    ((PlayerInterface) tempObject).getAction().setFacingRight(false);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Run);
                    ((PlayerInterface) tempObject).getAction().setFacingRight(true);
                }
                if (key == KeyEvent.VK_SPACE) {
//                    System.out.println("Attack! Or jump, idk yet");
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Attack1);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                    ((PlayerInterface) tempObject).getAction().setFacingRight(false);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(5);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                    ((PlayerInterface) tempObject).getAction().setFacingRight(true);
                }
                if (key == KeyEvent.VK_ENTER) {
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Attack1);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObjectInt tempObject : handler.objects) {
            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                    tempObject.setVelX(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_SPACE) {
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(0);
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
                if (key == KeyEvent.VK_ENTER) {
                    ((PlayerInterface) tempObject).getAction().setActionType(PlayerActions.Idle);
                }
            }
        }
    }
}

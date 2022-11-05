package window;

import characters.Player;
import characters.PlayerAnimationType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final MyHandler handler;

    public KeyInput(MyHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject : handler.objects) {
            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Jump);
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Fall);
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.RunLeft);
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Run);
                }
                if (key == KeyEvent.VK_SPACE) {
//                    System.out.println("Attack! Or jump, idk yet");
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Attack1);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject : handler.objects) {
            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
                    tempObject.setVelY(0);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Idle);
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_D) {
                    tempObject.setVelX(0);
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Idle);
                }
                if (key == KeyEvent.VK_SPACE) {
                    ((Player) tempObject).getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Idle);
                }
            }

            if (tempObject.getId() == ID.Enemy) {
                // KEY EVENTS FOR ENEMY
                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
            }
        }
    }
}

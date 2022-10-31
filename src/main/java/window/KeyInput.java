package window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private MyHandler handler;

    public KeyInput(MyHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject tempObject : handler.objects) {
            if (tempObject.getId() == ID.Player) {
                // KEY EVENTS FOR PLAYER
                if (key == KeyEvent.VK_W) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S) tempObject.setVelY(5);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
                if (key == KeyEvent.VK_D) tempObject.setVelX(5);
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
                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
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

package window;

import java.awt.*;
import java.util.LinkedList;

public class MyHandler {
    /**
     * Loops through all the objects in the game and individually update them and render them to the screen
     */

    public LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject tempObject : objects) {
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}

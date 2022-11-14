package window;

import java.awt.*;
import java.util.LinkedList;

/**
 * Loops through all the objects in the game and individually update them and render them to the screen
 */
public class MyHandler {
    public LinkedList<GameObjectInt> objects = new LinkedList<>();

    public void addObject(GameObjectInt object) {
        this.objects.add(object);
    }

    public void removeObject(GameObjectInt object) {
        this.objects.remove(object);
    }

    public void tick() {
        for (GameObjectInt tempObject : objects) {
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObjectInt tempObject : objects) {
            tempObject.render(g);
        }
    }
}

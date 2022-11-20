package window;

import window.GameObject.GameObjectInt;
import window.GameObject.MovingGameObjectInt;

import java.awt.*;
import java.util.LinkedList;

/**
 * Loops through all the objects in the game and individually update them and render them to the screen
 */
public class MyHandler {
    private LinkedList<GameObjectInt> objects = new LinkedList<>();
    private LinkedList<MovingGameObjectInt> movingObjects = new LinkedList<>();

    public LinkedList<GameObjectInt> getObjects() {
        LinkedList<GameObjectInt> gameObjectList = new LinkedList<GameObjectInt>();
        gameObjectList.addAll(objects);
        gameObjectList.addAll(movingObjects);
        return gameObjectList;
    }

    public LinkedList<MovingGameObjectInt> getOnlyMovingObjects() {
        return movingObjects;
    }

    public void addObject(GameObjectInt object) {
        this.objects.add(object);
    }

    public void removeObject(GameObjectInt object) {
        this.objects.remove(object);
    }

    public void addObject(MovingGameObjectInt movingObjects) {
        this.movingObjects.add(movingObjects);
    }

    public void removeObject(MovingGameObjectInt movingObjects) {
        this.movingObjects.remove(movingObjects);
    }

    public void tick() {
        for (GameObjectInt tempObject : objects) {
            tempObject.tick();
        }
        for (MovingGameObjectInt tempObject : movingObjects) {
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObjectInt tempObject : objects) {
            tempObject.render(g);
        }
        for (MovingGameObjectInt tempObject : movingObjects) {
            tempObject.render(g);
        }
    }
}

package UI;

import utils.Events;
import window.GameObject.GameObject;
import window.GameObject.ID;
import window.MyHandler;

import java.awt.*;

public class EventClass extends GameObject {
    private final MyHandler handler;

    public EventClass(MyHandler handler) {
        super(0, 0, ID.Event);
        this.handler = handler;
    }

    @Override
    public void tick() {
        Events.ticketeTickete(handler);
    }

    @Override
    public void render(Graphics g) {
    }
}

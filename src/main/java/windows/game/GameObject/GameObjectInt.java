package windows.game.GameObject;

import java.awt.*;

public interface GameObjectInt {
    void tick();

    void render(Graphics g);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    ID getId();

    void setId(ID id);
}

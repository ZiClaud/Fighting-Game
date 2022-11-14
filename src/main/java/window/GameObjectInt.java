package window;

import java.awt.*;

public interface GameObjectInt {
    public abstract void tick();

    public abstract void render(Graphics g);

    int getX();

    void setX(int x);

    int getY();

    public void setY(int y);

    public ID getId();

    public void setId(ID id);

    public int getVelX();

    public void setVelX(int velX);

    public int getVelY();

    public void setVelY(int velY);
}

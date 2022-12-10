package windows.game.GameObject;

public abstract class MovingGameObject extends GameObject implements MovingGameObjectInt {

    protected int velX, velY;

    public MovingGameObject(int x, int y, ID id) {
        super(x, y, id);
    }


    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}

package windows.game.GameObject;

public interface MovingGameObjectInt extends GameObjectInt {
    // TODO: Maybe move here the Gravity stuff

    int getVelX();

    void setVelX(int velX);

    int getVelY();

    void setVelY(int velY);
}

package actions;

public interface ActionInterface {
    PlayerActions getActionType();

    void setActionType(PlayerActions actionType);

    boolean isFacingRight();

    void setFacingRight(boolean facingRight);

    void act();

    void idle();

    void run();

    void jump();

    void fall();

    void attack1();

    void attack2();

    void takeHit();

    void death();
}

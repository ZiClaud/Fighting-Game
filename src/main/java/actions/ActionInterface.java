package actions;

public interface ActionInterface {
    PlayerAction getActionType();

    void setActionType(PlayerAction actionType);

    boolean isFacingRight();

    void setFacingRight(boolean facingRight);

    void act();
}

package zGardbage.the_actions.movement;

import zGardbage.the_actions.TheAction;
import zGardbage.the_actions.ActionType;
import characters.PlayerInterface;

public class Facing extends TheAction {
    Boolean facingRight;

    public Facing(PlayerInterface player, ActionType actionType) {
        super(player, actionType);
    }

    public Boolean getFacingRight() {
        return facingRight;
    }

    public void setFacingRight(Boolean facingRight) {
        this.facingRight = facingRight;
    }
}

package zGardbage.the_actions.movement;

import zGardbage.the_actions.TheAction;
import zGardbage.the_actions.ActionType;
import characters.Player;

public class Facing extends TheAction {
    Boolean facingRight;

    public Facing(Player player, ActionType actionType) {
        super(player, actionType);
    }

    public Boolean getFacingRight() {
        return facingRight;
    }

    public void setFacingRight(Boolean facingRight) {
        this.facingRight = facingRight;
    }
}

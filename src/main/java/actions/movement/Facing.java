package actions.movement;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Facing extends Action {
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

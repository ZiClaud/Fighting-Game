package zGardbage.the_actions.movement;

import zGardbage.the_actions.TheAction;
import zGardbage.the_actions.ActionType;
import characters.Player;

public class Moving extends TheAction {
    boolean moving;

    public Moving(Player player, ActionType actionType, boolean moving) {
        super(player, actionType);
        this.moving = moving;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}

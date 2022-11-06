package actions.movement;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Moving extends Action {
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

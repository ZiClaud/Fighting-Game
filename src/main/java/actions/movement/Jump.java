package actions.movement;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Jump extends Action {
    double jumpSpeed;
    double jumpHeight;

    public Jump(Player player, ActionType actionType) {
        super(player, actionType);
    }

    public double getJumpSpeed() {
        return jumpSpeed;
    }

    public void setJumpSpeed(double jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }
}

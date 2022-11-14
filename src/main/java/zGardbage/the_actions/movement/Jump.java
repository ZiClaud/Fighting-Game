package zGardbage.the_actions.movement;

import zGardbage.the_actions.ActionType;
import zGardbage.the_actions.TheAction;
import characters.PlayerInterface;

public class Jump extends TheAction {
    double jumpSpeed;
    double jumpHeight;

    public Jump(PlayerInterface player, ActionType actionType) {
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

    public boolean isJumping() {
        return player.getVelY() > 0;
    }
}

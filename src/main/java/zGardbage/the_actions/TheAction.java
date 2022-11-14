package zGardbage.the_actions;

import characters.PlayerInterface;

public abstract class TheAction {
    protected PlayerInterface player;
    protected ActionType actionType;

    public TheAction(PlayerInterface player, ActionType actionType) {
        this.player = player;
        this.actionType = actionType;
    }
}

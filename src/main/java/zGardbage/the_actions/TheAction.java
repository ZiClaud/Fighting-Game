package zGardbage.the_actions;

import characters.Player;

public abstract class TheAction {
    protected Player player;
    protected ActionType actionType;

    public TheAction(Player player, ActionType actionType) {
        this.player = player;
        this.actionType = actionType;
    }
}

package actions;

import characters.Player;

public abstract class Action {
    protected Player player;
    protected ActionType actionType;

    public Action(Player player, ActionType actionType) {
        this.player = player;
        this.actionType = actionType;
    }
}

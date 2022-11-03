package actions.fight;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Fight extends Action {
    public Fight(Player player, ActionType actionType) {
        super(player, actionType);
    }
}

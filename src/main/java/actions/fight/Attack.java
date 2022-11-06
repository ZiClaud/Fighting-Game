package actions.fight;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Attack extends Action {
    public Attack(Player player, ActionType actionType) {
        super(player, actionType);
    }
}

package actions.fight;

import actions.Action;
import actions.ActionType;
import characters.Player;

public class Damage extends Action {
    public Damage(Player player, ActionType actionType) {
        super(player, actionType);
    }
}

package zGardbage.the_actions.fight;

import zGardbage.the_actions.ActionType;
import zGardbage.the_actions.TheAction;
import characters.Player;

public class Attack extends TheAction {
    public Attack(Player player, ActionType actionType) {
        super(player, actionType);
    }
}

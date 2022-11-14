package zGardbage.the_actions.fight;

import zGardbage.the_actions.ActionType;
import zGardbage.the_actions.TheAction;
import characters.PlayerInterface;

public class Attack extends TheAction {
    public Attack(PlayerInterface player, ActionType actionType) {
        super(player, actionType);
    }
}

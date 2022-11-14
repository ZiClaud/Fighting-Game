package zGardbage.the_actions.fight;

import zGardbage.the_actions.TheAction;
import zGardbage.the_actions.ActionType;
import characters.PlayerInterface;

public class Damage extends TheAction {
    public Damage(PlayerInterface player, ActionType actionType) {
        super(player, actionType);
    }
}

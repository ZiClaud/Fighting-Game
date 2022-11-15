package characters;

import actions.ActionInterface;
import actions.PlayerAction;

public interface ObserverAnimation {
    void update(ActionInterface action);
    void update(PlayerAction playerAction);
    void update(PlayerAction playerAction, boolean isFacingRight);
}

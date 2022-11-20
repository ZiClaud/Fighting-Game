package characters;

import actions.Action;
import actions.PlayerAction;

public interface ObserverAnimation {
    void update(Action action);

    void update(PlayerAction playerAction);

    void update(PlayerAction playerAction, boolean isFacingRight);
}

package characters;

import actions.ActionType;

public interface ObserverAnimation {
    void addPlayerAction(ActionType actionType);

    void addPlayerAction(ActionType actionType, boolean isFacingRight);

    void removePlayerAction(ActionType actionType);

    void removePlayerAction(ActionType actionType, boolean isFacingRight);
}

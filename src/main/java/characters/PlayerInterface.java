package characters;

import actions.Action;
import actions.AnimatePlayer;
import window.GameObjectInt;

public interface PlayerInterface extends GameObjectInt {
    PlayerImage getPlayerImage();

    int getHp();

    void setHp(int hp);

    String getUsername();

    PlayerSizeInterface getSize();

    Action getAction();

    AnimatePlayer getAnimatePlayer();
}

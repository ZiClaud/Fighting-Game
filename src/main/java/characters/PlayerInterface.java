package characters;

import actions.ActionInterface;
import window.GameObjectInt;

public interface PlayerInterface extends GameObjectInt {
    PlayerImage getPlayerImage();

    int getHp();

    void setHp(int hp);

    String getUsername();

    PlayerSizeInterface getSize();

    ActionInterface getAction();
}

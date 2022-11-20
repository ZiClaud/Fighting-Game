package characters;

import actions.Action;
import actions.AnimatePlayer;
import window.GameObject.MovingGameObjectInt;

public interface PlayerInterface extends MovingGameObjectInt {
    PlayerImage getPlayerImage();

    int getHp();

    void setHp(int hp);

    String getUsername();

    PlayerSizeInterface getSize();

    Action getAction();

    AnimatePlayer getAnimatePlayer();
}

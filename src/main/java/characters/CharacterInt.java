package characters;

import actions.AnimatePlayer;
import window.game.GameObject.MovingGameObjectInt;

public interface CharacterInt extends MovingGameObjectInt {
    PlayerImage getPlayerImage();

    int getHp();

    void setHp(int hp);

    String getUsername();

    PlayerSizeInt getSize();

    AnimatePlayer getAnimatePlayer();
}

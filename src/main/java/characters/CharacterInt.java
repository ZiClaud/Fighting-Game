package characters;

import actions.AnimatePlayer;
import actions.box.Skin;
import windows.game.GameObject.MovingGameObjectInt;

public interface CharacterInt extends MovingGameObjectInt {
    PlayerImage getPlayerImage();

    int getHp();

    void setHp(int hp);

    String getUsername();

    AnimatePlayer getAnimatePlayer();

    Skin getSkin();

    void setSkin(Skin skin);

    boolean isShowDevSquare();

    void setShowDevSquare(boolean showDevSquare);
}

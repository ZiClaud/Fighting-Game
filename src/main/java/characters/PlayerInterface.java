package characters;

import actions.Action;
import window.GameObjectInt;

public interface PlayerInterface extends GameObjectInt {
    public abstract PlayerImage getPlayerImage();

    public abstract int getHp();

    public abstract void setHp(int hp);

    public abstract String getUsername();

    public abstract PlayerSize getSize();

    public abstract Action getAction();
}

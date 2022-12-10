package characters;

import actions.box.Skin;
import windows.game.GameObject.ID;

public class Enemy extends PlayerAC {
    public Enemy(int x, int y, ID id, int hp, String username, Skin skin) {
        super(x, y, id, hp, username, skin);
    }
}

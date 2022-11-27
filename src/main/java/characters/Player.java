package characters;

import actions.imgsFactory.Skin;
import window.game.GameObject.ID;

public class Player extends PlayerAC {
    public Player(int x, int y, ID id, int hp, String username, Skin skin) {
        super(x, y, id, hp, username, skin);
    }
}

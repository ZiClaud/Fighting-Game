package characters;

import window.GameObject.ID;

public class Enemy extends PlayerAC {
    public Enemy(int x, int y, ID id, int playerWidth, int playerHeight, int hp, String username) {
        super(x, y, id, playerWidth, playerHeight, hp, username);
    }
}

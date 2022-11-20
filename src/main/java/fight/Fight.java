package fight;

import characters.CharacterInt;
import window.GameObject.GameObject;
import window.GameObject.ID;

import java.awt.*;

public class Fight extends GameObject {
    CharacterInt player;
    CharacterInt enemy;

    public Fight(int x, int y, ID id, CharacterInt player, CharacterInt enemy) {
        super(x, y, id);
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}

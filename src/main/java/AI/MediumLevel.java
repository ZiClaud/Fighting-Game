package AI;

import characters.CharacterInt;
import window.game.KeyPressed;

import java.util.Random;

public class MediumLevel extends AI {
    Random r = new Random();

    public MediumLevel(CharacterInt ai, CharacterInt player) {
        this.ai = ai;
        this.player = player;
    }

    @Override
    public void tick() {
        if (canAIMove()) {
            move();
        }
    }

    @Override
    public void move() {
        if (ai.getHp() > 30) {
            followPlayer();
        } else {
            escapePlayer();
        }
    }

    @Override
    public void jump() {
        KeyPressed.pressedW(ai.getAnimatePlayer());
    }

    @Override
    public void attack() {
        KeyPressed.pressedSpace(ai.getAnimatePlayer());
    }
}

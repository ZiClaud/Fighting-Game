package AI;

import characters.CharacterInt;
import window.game.KeyPressed;

import java.util.Random;

public class HardLevel extends AI {
    Random r = new Random();

    public HardLevel(CharacterInt ai, CharacterInt player) {
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
        if (ai.getHp() > 0) {
            followPlayer();
        } else {
            escapePlayer();
        }
    }

    private void followPlayer() {
        if (getAIMiddle() - 20 > getPlayerMiddle() + 20) {
            KeyPressed.pressedA(ai.getAnimatePlayer(), ai);
        } else if (getAIMiddle() + 20 < getPlayerMiddle() - 20) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
        } else {
            if (r.nextInt(0, 10) > 8) {
                attack();
            } else {
                jump();
            }
        }
    }

    private void escapePlayer() {
        if (getAIMiddle() - 20 > getPlayerMiddle() + 20) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
        } else if (ai.getSize().getMiddleX(ai.getX()) + 20 < player.getSize().getMiddleX(player.getX()) - 20) {
            KeyPressed.pressedA(ai.getAnimatePlayer(), ai);
        } else {
            facePlayer();
            followPlayer();
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

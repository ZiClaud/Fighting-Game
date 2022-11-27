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
        if (getAIMiddle() - 25 > getPlayerMiddle() + 25) {
            KeyPressed.pressedA(ai.getAnimatePlayer(), ai);
        } else if (getAIMiddle() + 25 < getPlayerMiddle() - 25) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
        } else {
            facePlayer();
            if (r.nextInt(0, 10) > 8) {
                attack();
            } else {
                jump();
            }
        }
    }

    private void escapePlayer() {
        if (getAIMiddle() - 40 > getPlayerMiddle() + 40) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
        } else if (ai.getSize().getMiddleX(ai.getX()) + 40 < player.getSize().getMiddleX(player.getX()) - 40) {
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

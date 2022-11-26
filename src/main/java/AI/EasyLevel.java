package AI;

import characters.CharacterInt;
import window.game.KeyPressed;

import java.util.Random;

public class EasyLevel extends AI {
    Random r = new Random();

    public EasyLevel(CharacterInt ai, CharacterInt player) {
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
        if (ai.getHp() > 90) {
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
            if (r.nextInt(0, 10) < 3) {
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

package AI;

import characters.CharacterInt;
import window.game.Game;
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
//        goToCenter();
    }

    private void followPlayer() {
        if (getAIMiddle() - 20 > getPlayerMiddle() + 20) {
            KeyPressed.pressedA(ai.getAnimatePlayer(), ai);
        } else if (getAIMiddle() + 20 < getPlayerMiddle() - 20 || getAIMiddle() < 30) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
        } else {
            facePlayer();
            if (r.nextInt(0, 10) <= 10) {
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

    private boolean isOnBorder(){
        return (isOnLeftBorder() || isOnRightBorder());
    }

    private boolean isOnRightBorder(){
        return getAIMiddle() > Game.WIDTH_WINDOW - 30;
    }

    private boolean isOnLeftBorder(){
        return getAIMiddle() < 30;
    }

    private void goToCenter(){
        if (isOnRightBorder()){
            KeyPressed.pressedA(ai.getAnimatePlayer(), ai);
        } else if (isOnLeftBorder()) {
            KeyPressed.pressedD(ai.getAnimatePlayer(), ai);
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

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

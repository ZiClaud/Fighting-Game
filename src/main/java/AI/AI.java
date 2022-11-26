package AI;

import actions.ActionType;
import characters.CharacterInt;
import window.game.GameObject.GameObject;
import window.game.GameObject.ID;
import window.game.KeyInput;
import window.game.KeyPressed;

import java.awt.*;

public abstract class AI extends GameObject implements AIInterface {
    protected CharacterInt ai;
    protected CharacterInt player;

    public AI() {
        super(0, 0, ID.AI);
    }

    @Override
    public void render(Graphics g) {
        // DO NOTHING
    }

    protected boolean canAIMove() {
        return (ai.getAnimatePlayer().getAction().getBestActionType() != ActionType.TakeHit &&
                ai.getAnimatePlayer().getAction().getBestActionType() != ActionType.TakeHitC &&
                ai.getAnimatePlayer().getAction().getBestActionType() != ActionType.Death &&
                KeyInput.canMove());
    }

    protected int getAIMiddle() {
        return ai.getSize().getMiddleX(ai.getX());
    }

    protected int getPlayerMiddle() {
        return player.getSize().getMiddleX(player.getX());
    }

    protected void facePlayer() {
        KeyPressed.changeFacing(ai.getAnimatePlayer(), getAIMiddle() <= getPlayerMiddle());
    }
}

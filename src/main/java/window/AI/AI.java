package window.AI;

import actions.ActionType;
import characters.CharacterInt;
import window.GameObject.GameObject;
import window.GameObject.ID;
import window.KeyPressed;

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
                ai.getAnimatePlayer().getAction().getBestActionType() != ActionType.Death);
    }

    protected int getAIMiddle() {
        return ai.getSize().getMiddleX(ai.getX());
    }

    protected int getPlayerMiddle() {
        return player.getSize().getMiddleX(player.getX());
    }

    protected void facePlayer() {
        if (getAIMiddle() > getPlayerMiddle()){
            KeyPressed.changeFacing(ai.getAnimatePlayer(), false);
        } else {
            KeyPressed.changeFacing(ai.getAnimatePlayer(), true);
        }
    }
}

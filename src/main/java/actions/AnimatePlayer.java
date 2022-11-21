package actions;

import characters.CharacterInt;
import characters.ObserverAnimation;
import utils.Events;
import window.GameObject.ID;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatePlayer implements ObserverAnimation {
    private CharacterInt player;
    private Action action;
    private ArrayList<BufferedImage> currentAnimation;
    private int i = 0;

    public AnimatePlayer(CharacterInt player) {
        this.player = player;
        this.action = player.getAction();
    }

    public void animatePlayer() {
        updateMore();
        loopAnimation();
    }

    private void loopAnimation() {
        Timer timer = new Timer(200, e -> {
            if (i >= currentAnimation.size()) {
//                System.out.println(i);
                i = 0;
            }
            //System.out.println("I: " + i);
            player.getPlayerImage().setImg(currentAnimation.get(i));
            i++;
            Events.animationEvent(player, i);
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    @Override
    public void update(Action action) {
        this.action = action;
        updateMore();
    }

    @Override
    public void update(PlayerAction playerAction, boolean isFacingRight) {
        if (action.getActionType() == playerAction && action.isFacingRight() == isFacingRight)
            return;

        action.setActionType(playerAction);
        action.setFacingRight(isFacingRight);
        updateMore();
    }

    @Override
    public void update(PlayerAction playerAction) {
        if (action.getActionType() == playerAction)
            return;
        action.setActionType(playerAction);
        updateMore();
    }

    private void updateMore() {
        i = 0;
        if (player.getId() == ID.Player) {
            currentAnimation = CharacterImagesFromResources.getPlayerImg(action.getActionType(), action.isFacingRight());
        } else if (player.getId() == ID.Enemy) {
            currentAnimation = CharacterImagesFromResources.getEnemyImg(action.getActionType(), action.isFacingRight());
        }
    }
}

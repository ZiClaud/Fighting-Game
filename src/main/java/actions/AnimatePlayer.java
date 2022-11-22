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
    public void addPlayerAction(ActionType actionType, boolean isFacingRight) {
        action.addActionType(actionType);
        action.setFacingRight(isFacingRight);
        updateMore();
    }

    @Override
    public void addPlayerAction(ActionType actionType) {
        action.addActionType(actionType);
        updateMore();
    }

    @Override
    public void removePlayerAction(ActionType actionType) {
        action.removeActionType(actionType);
        updateMore();
    }

    @Override
    public void removePlayerAction(ActionType actionType, boolean isFacingRight) {
        action.removeActionType(actionType);
        action.setFacingRight(isFacingRight);
        updateMore();
    }

    private void updateMore() {
//        i = 0;
        if (player.getId() == ID.Player) {
            currentAnimation = CharacterImagesFromResources.getPlayerImg(action.getBestActionType(), action.isFacingRight());
        } else if (player.getId() == ID.Enemy) {
            currentAnimation = CharacterImagesFromResources.getEnemyImg(action.getBestActionType(), action.isFacingRight());
        }
    }
}

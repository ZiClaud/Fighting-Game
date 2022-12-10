package actions;

import actions.imgsFactory.CharacterImagesFromResources;
import actions.imgsFactory.ImagesFromResourcesFactory;
import characters.CharacterInt;
import characters.ObserverAnimation;
import events.Events;
import windows.game.GameObject.ID;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatePlayer implements ObserverAnimation {
    private final CharacterInt player;
    private final Action action;
    private final CharacterImagesFromResources characterImagesFromResources;
    private ArrayList<BufferedImage> currentAnimation;
    private int i = 0;
    private ActionType previousBestActionType = ActionType.Idle;

    public AnimatePlayer(CharacterInt player) {
        this.player = player;
        this.action = new Action(player);

        this.characterImagesFromResources = ImagesFromResourcesFactory.createCharacterImagesFromResources(player.getSkin());
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

    public Action getAction() {
        return action;
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
        /**
         * Resets "i" only when the "action.getBestActionType()" changes
         */
        if (previousBestActionType != action.getBestActionType()) {
            i = 0;
            previousBestActionType = action.getBestActionType();
        }
        if (player.getId() == ID.Player) {
            currentAnimation = characterImagesFromResources.getImg(action.getBestActionType(), action.isFacingRight());
        } else if (player.getId() == ID.Enemy) {
            currentAnimation = characterImagesFromResources.getImg(action.getBestActionType(), action.isFacingRight());
        }
    }
}

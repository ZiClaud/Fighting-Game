package characters;

import actions.ActionInterface;
import actions.PlayerAction;
import window.ID;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimatePlayer implements ObserverAnimation {
    private PlayerInterface player;
    private ActionInterface action;
    private ArrayList<BufferedImage> currentAnimation;
    private int i = 0;

    public AnimatePlayer(PlayerInterface player) {
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
            event();
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    private void event(){   // TODO: Use wisely
        if (player.getId() == ID.Player) {
            if (action.getActionType() == PlayerAction.Attack1 && i == 5) {
                System.out.println("Attack1! by player");
//            Events.hit();
            }
        } else if (player.getId() == ID.Enemy) {
            if (action.getActionType() == PlayerAction.Attack1 && i == 3) {
                System.out.println("Attack1! by enemy");
//            Events.hit();
            }
        }
    }
    @Override
    public void update(ActionInterface action) {
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
            currentAnimation = PlayerImagesFromResources.getPlayerImg(action.getActionType(), action.isFacingRight());
        } else if (player.getId() == ID.Enemy) {
            currentAnimation = PlayerImagesFromResources.getEnemyImg(action.getActionType(), action.isFacingRight());
        }
    }
}

package characters;

import window.MyHandler;

import javax.swing.*;

public class AnimatePlayer {
    Player player;
    MyHandler handler;
    int i = 0;

    public AnimatePlayer(Player player) {
        this.player = player;
    }

    public void animatePlayer() {
        if (player.getPlayerAnimationType() == PlayerAnimationType.Idle || player.getPlayerAnimationType() == PlayerAnimationType.Run || player.getPlayerAnimationType() == PlayerAnimationType.RunLeft || player.getPlayerAnimationType() == PlayerAnimationType.Jump || player.getPlayerAnimationType() == PlayerAnimationType.Fall) {
            System.out.println("loop animation ActionCommand");
            loopAnimation();
        } else {
            System.out.println("ActionCommand");
            actionAnimation();
        }
    }

    private void loopAnimation() {
        Timer timer = new Timer(200, e -> {
            if (i >= PlayerImg.getPlayerImg(player.getPlayerAnimationType()).size()) {
                System.out.println("Loop Animation: " + i);
                i = 0;
            }
            player.setImg(PlayerImg.getPlayerImg(player.getPlayerAnimationType()).get(i));
            i++;
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    private void actionAnimation() {
        i = 0;
        Timer timer = new Timer(200, e -> {
            if (i >= PlayerImg.getPlayerImg(player.getPlayerAnimationType()).size()) {
                System.out.println("Animation: " + i);
                i = 0;
            }
            player.setImg(PlayerImg.getPlayerImg(player.getPlayerAnimationType()).get(i));
            i++;
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
}

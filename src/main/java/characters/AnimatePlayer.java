package characters;

import javax.swing.*;

public class AnimatePlayer {
    Player player;
    int i = 0;

    public AnimatePlayer(Player player) {
        this.player = player;
    }

    public void animatePlayer() {
        loopAnimation();
    }

    private void loopAnimation() {
        Timer timer = new Timer(200, e -> {
            if (i >= PlayerImg.getPlayerImg(player.getPlayerAnimationType()).size()) {
                i = 0;
            }
            player.setImg(PlayerImg.getPlayerImg(player.getPlayerAnimationType()).get(i));
            i++;
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    private void actionAnimation(){

    }
}

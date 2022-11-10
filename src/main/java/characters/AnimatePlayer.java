package characters;

import window.ID;

import javax.swing.*;

public class AnimatePlayer {
    Player player;
    int i = 0;
    int j = 0;

    public AnimatePlayer(Player player) {
        this.player = player;
    }

    public void animatePlayer() {
        if (player.getId() == ID.Player) {
            loopAnimationPlayer();
            /*
            if (player.getPlayerImage().getPlayerAnimationType() == PlayerAnimationType.Idle || player.getPlayerImage().getPlayerAnimationType() == PlayerAnimationType.Run || player.getPlayerImage().getPlayerAnimationType() == PlayerAnimationType.RunLeft || player.getPlayerImage().getPlayerAnimationType() == PlayerAnimationType.Jump || player.getPlayerImage().getPlayerAnimationType() == PlayerAnimationType.Fall) {
                //System.out.println("loop animation ActionCommand");
                loopAnimationPlayer();
            } else {
                //System.out.println("action animation ActionCommand");
                actionAnimation();
            }
            */
        } else if (player.getId() == ID.Enemy) {
            loopAnimationEnemy();
        }
    }

    private void loopAnimationPlayer() {
        Timer timerPlayer = new Timer(200, e -> {
            if (i >= ImagePlayer.getPlayerImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).size()) {
                //System.out.println("Loop Animation Player: " + i);
                i = 0;
            }
            player.getPlayerImage().setImg(ImagePlayer.getPlayerImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).get(i));
            i++;
        });
        timerPlayer.setRepeats(true);
        timerPlayer.setCoalesce(true);
        timerPlayer.start();
    }

    private void loopAnimationEnemy() {
        Timer timerEnemy = new Timer(400, e -> {
            if (j >= ImagePlayer.getEnemyImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).size()) {
                //System.out.println("Loop Animation Enemy: " + j);
                j = 0;
            }
            player.getPlayerImage().setImg(ImagePlayer.getEnemyImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).get(i));
            j++;
        });
        timerEnemy.setRepeats(true);
        timerEnemy.setCoalesce(true);
        timerEnemy.start();
    }


    private void actionAnimation() {
        i = 0;
        Timer timer = new Timer(200, e -> {
            if (i >= ImagePlayer.getPlayerImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).size()) {
                System.out.println("Animation: " + i);
                i = 0;
            }
            player.getPlayerImage().setImg(ImagePlayer.getPlayerImg(player.getPlayerImage().getPlayerAnimationType(), player.getAction().isFacingRight()).get(i));
            i++;
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
}

package actions;

import characters.PlayerInterface;

public class Action implements ActionInterface {
    private final PlayerInterface player;
    private PlayerActions actionType;
    private boolean facingRight = true;

    public Action(PlayerInterface player) {
        this.player = player;
        this.actionType = PlayerActions.Idle;
    }

    public PlayerActions getActionType() {
        return actionType;
    }

    public void setActionType(PlayerActions actionType) {
        this.actionType = actionType;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void act() {
//        if (player.getAnimatePlayer().isLoopCompleted()) {
            if (getActionType() == PlayerActions.Idle) {
                idle();
            } else if (getActionType() == PlayerActions.Run) {
                run();
            } else if (getActionType() == PlayerActions.Jump) {
                jump();
            } else if (getActionType() == PlayerActions.Fall) {
                fall();
            } else if (getActionType() == PlayerActions.Attack1) {
                attack1();
            } else if (getActionType() == PlayerActions.Attack2) {
                attack2();
            } else if (getActionType() == PlayerActions.TakeHit) {
                takeHit();
            } else if (getActionType() == PlayerActions.Death) {
                death();
            }
   //     }
    }

    public void idle() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Idle);
    }

    public void run() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Run);
    }

    public void jump() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Jump);
    }

    public void fall() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Fall);
    }

    public void attack1() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Attack1);
    }

    public void attack2() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Attack2);
    }

    public void takeHit() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.TakeHit);
    }

    public void death() {
        player.getPlayerImage().setPlayerAnimationType(PlayerActions.Death);
    }
}

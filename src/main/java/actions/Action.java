package actions;

import characters.PlayerInterface;

public class Action implements ActionInterface {
    private final PlayerInterface player;
    private PlayerAction actionType;
    private boolean facingRight = true;

    public Action(PlayerInterface player) {
        this.player = player;
        this.actionType = PlayerAction.Idle;
    }

    public PlayerAction getActionType() {
        return actionType;
    }

    public void setActionType(PlayerAction actionType) {
        this.actionType = actionType;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void act() {
        if (getActionType() == PlayerAction.Idle) {
            idle();
        } else if (getActionType() == PlayerAction.Run) {
            run();
        } else if (getActionType() == PlayerAction.Jump) {
            jump();
        } else if (getActionType() == PlayerAction.Fall) {
            fall();
        } else if (getActionType() == PlayerAction.Attack1) {
            attack1();
        } else if (getActionType() == PlayerAction.Attack2) {
            attack2();
        } else if (getActionType() == PlayerAction.TakeHit) {
            takeHit();
        } else if (getActionType() == PlayerAction.Death) {
            death();
        }
    }

    public void idle() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Idle);
    }

    public void run() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Run);
    }

    public void jump() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Jump);
    }

    public void fall() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Fall);
    }

    public void attack1() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Attack1);
    }

    public void attack2() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Attack2);
    }

    public void takeHit() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.TakeHit);
    }

    public void death() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Death);
    }
}

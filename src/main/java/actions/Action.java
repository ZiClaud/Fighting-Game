package actions;

import characters.PlayerAnimationType;
import characters.PlayerData;

public class Action {
    private final PlayerData playerData;
    private PlayerAnimationType actionType;
    private boolean facingRight = true;

    public Action(PlayerData playerData) {
        this.playerData = playerData;
        this.actionType = PlayerAnimationType.Idle;
    }

    public PlayerAnimationType getActionType() {
        return actionType;
    }

    public void setActionType(PlayerAnimationType actionType) {
        this.actionType = actionType;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void act() {
        if (getActionType() == PlayerAnimationType.Idle) {
            idle();
        } else if (getActionType() == PlayerAnimationType.Run) {
            run();
        } else if (getActionType() == PlayerAnimationType.Jump) {
            jump();
        } else if (getActionType() == PlayerAnimationType.Fall) {
            fall();
        } else if (getActionType() == PlayerAnimationType.Attack1) {
            attack1();
        } else if (getActionType() == PlayerAnimationType.Attack2) {
            attack2();
        } else if (getActionType() == PlayerAnimationType.TakeHit) {
            takeHit();
        } else if (getActionType() == PlayerAnimationType.Death) {
            death();
        }
    }

    public void idle() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Idle);
    }

    public void run() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Run);
    }

    public void jump() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Jump);
    }

    public void fall() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Fall);
    }

    public void attack1() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Attack1);
    }

    public void attack2() {
        playerData.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Attack2);
    }

    public void takeHit() {
        playerData.getPlayerImage().setPlayerAnimationType(PlayerAnimationType.TakeHit);
    }

    public void death() {
        playerData.getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Death);
    }
}

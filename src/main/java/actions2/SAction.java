package actions2;

import characters.Player;
import characters.PlayerAnimationType;

public class SAction {
    private final Player player;
    private PlayerAnimationType actionType;
    private boolean facingRight = true;

    public SAction(Player player) {
        this.player = player;
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
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Idle);
    }

    public void run() {
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Run);
    }

    public void jump() {
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Jump);
    }

    public void fall() {
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Fall);
    }

    public void attack1() {
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Attack1);
    }

    public void attack2() {
        player.getPlayerImage().setPlayerAnimationType(characters.PlayerAnimationType.Attack2);
    }

    public void takeHit() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAnimationType.TakeHit);
    }

    public void death() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAnimationType.Death);
    }
}

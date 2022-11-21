package actions;

import characters.CharacterInt;

public class Action {
    private final CharacterInt player;
    private PlayerAction actionType;
    private boolean facingRight = true;

    public Action(CharacterInt player) {
        this.player = player;
        this.actionType = PlayerAction.Idle;
    }

    public PlayerAction getActionType() {
        return actionType;
    }

    protected void setActionType(PlayerAction actionType) {
        this.actionType = actionType;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    protected void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void act() {
//        if (player.getAnimatePlayer().isLoopCompleted()) {
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
        //     }
    }

    private void idle() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Idle);
    }

    private void run() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Run);
    }

    private void jump() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Jump);
    }

    private void fall() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Fall);
    }

    private void attack1() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Attack1);
    }

    private void attack2() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Attack2);
    }

    private void takeHit() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.TakeHit);
    }

    private void death() {
        player.getPlayerImage().setPlayerAnimationType(PlayerAction.Death);
    }
}

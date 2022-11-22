package actions;

import characters.CharacterInt;

import java.util.HashSet;

public class Action {
    private final CharacterInt player;
    private HashSet<ActionType> actionTypeList = new HashSet<>();

    public Action(CharacterInt player) {
        this.player = player;
        actionTypeList.add(ActionType.Idle);
    }

    public HashSet<ActionType> getActionTypeSet() {
        return actionTypeList;
    }


    /**
     * IMPORTANT: THE ORDER OF THIS IS FUNDAMENTAL
     */
    public ActionType getBestActionType() {
        if (getActionTypeSet().contains(ActionType.Death)) {
            return ActionType.Death;
        } else if (getActionTypeSet().contains(ActionType.TakeHitC)) {
            return ActionType.TakeHitC;
        } else if (getActionTypeSet().contains(ActionType.TakeHit)) {
            return ActionType.TakeHit;
        } else if (getActionTypeSet().contains(ActionType.Attack1)) {
            return ActionType.Attack1;
        } else if (getActionTypeSet().contains(ActionType.Attack2)) {
            return ActionType.Attack2;
        } else if (getActionTypeSet().contains(ActionType.Jump)) {
            return ActionType.Jump;
        } else if (getActionTypeSet().contains(ActionType.Fall)) {
            return ActionType.Fall;
        } else if (getActionTypeSet().contains(ActionType.Run)) {
            return ActionType.Run;
        } else if (getActionTypeSet().contains(ActionType.Idle)) {
            return ActionType.Idle;
        }
        return ActionType.Idle;
    }

    protected void addActionType(ActionType actionType) {
        actionTypeList.add(actionType);
    }

    protected void removeActionType(ActionType actionType) {
        actionTypeList.remove(actionType);
    }

    public boolean isFacingRight() {
        return (getActionTypeSet().contains(ActionType.IsFacingRight));
    }

    protected void setFacingRight(boolean facingRight) {
        if (facingRight) {
            addActionType(ActionType.IsFacingRight);
        } else {
            removeActionType(ActionType.IsFacingRight);
        }
    }

    public void act() {
        for (ActionType actionType : getActionTypeSet()) {
            if (actionType == ActionType.Idle) {
                idle();
            } else if (actionType == ActionType.Run) {
                run();
            } else if (actionType == ActionType.Jump) {
                jump();
            } else if (actionType == ActionType.Fall) {
                fall();
            } else if (actionType == ActionType.Attack1) {
                attack1();
            } else if (actionType == ActionType.Attack2) {
                attack2();
            } else if (actionType == ActionType.TakeHit) {
                takeHit();
            } else if (actionType == ActionType.Death) {
                death();
            }
        }
    }

    private void idle() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Idle);
    }

    private void run() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Run);
    }

    private void jump() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Jump);
    }

    private void fall() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Fall);
    }

    private void attack1() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Attack1);
    }

    private void attack2() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Attack2);
    }

    private void takeHit() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.TakeHit);
    }

    private void death() {
        player.getPlayerImage().setPlayerAnimationType(ActionType.Death);
    }
}

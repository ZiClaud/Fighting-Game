package window.game;

import actions.ActionType;
import characters.CharacterInt;
import characters.ObserverAnimation;

public class KeyPressed {
    public static void pressedW(ObserverAnimation playerObserverAnimation) {
        playerObserverAnimation.addPlayerAction(ActionType.Jump);
    }

    public static void pressedS(ObserverAnimation playerObserverAnimation) {
    }

    public static void pressedA(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(-5);
        playerObserverAnimation.addPlayerAction(ActionType.Run, false);
    }

    public static void pressedD(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(5);
        playerObserverAnimation.addPlayerAction(ActionType.Run, true);
    }

    public static void pressedSpace(ObserverAnimation playerObserverAnimation) {
        playerObserverAnimation.addPlayerAction(ActionType.Attack1);
    }

    public static void releasedW(ObserverAnimation playerObserverAnimation) {
    }

    public static void releasedS(ObserverAnimation playerObserverAnimation) {
    }

    public static void releasedA(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(0);
        // TODO: CHECK IF IT'S OK
        playerObserverAnimation.removePlayerAction(ActionType.Run);

    }

    public static void releasedD(ObserverAnimation playerObserverAnimation, CharacterInt tempObject) {
        tempObject.setVelX(0);
        // TODO: CHECK IF IT'S OK
        playerObserverAnimation.removePlayerAction(ActionType.Run);
    }

    public static void releasedSpace(ObserverAnimation playerObserverAnimation) {
    }

    public static void changeFacing(ObserverAnimation playerObserverAnimation, boolean isFacingRight) {
        playerObserverAnimation.addPlayerAction(ActionType.Idle, isFacingRight);
    }

    public static void pressedF3(CharacterInt tempObject) {
        tempObject.setShowDevSquare(!tempObject.isShowDevSquare());
    }
}

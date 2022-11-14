package characters;

import actions.PlayerActions;

import java.awt.image.BufferedImage;

public class PlayerImage {
    private BufferedImage img;
    private PlayerActions playerActions = PlayerActions.Idle;

    public PlayerActions getPlayerAnimationType() {
        return playerActions;
    }

    public void setPlayerAnimationType(PlayerActions playerActions) {
        this.playerActions = playerActions;
        /*
        // TODO: This fixes bug that stops animation if I both jump and go right, but can't attack
        if (velX == 0 && velY == 0){
            this.playerAnimationType = PlayerAnimationType.Idle;
        } else if (velY < 0){
            this.playerAnimationType = PlayerAnimationType.Jump;
        } else if (velY > 0) {
            this.playerAnimationType = PlayerAnimationType.Fall;
        } else if (velX > 0){
            this.playerAnimationType = PlayerAnimationType.Run;
        } else if (velX < 0){
            this.playerAnimationType = PlayerAnimationType.RunLeft;
        }
        */
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}

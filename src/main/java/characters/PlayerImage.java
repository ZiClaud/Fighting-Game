package characters;

import actions.PlayerAction;

import java.awt.image.BufferedImage;

public class PlayerImage {
    private BufferedImage img;
    private PlayerAction playerAction = PlayerAction.Idle;

    public PlayerAction getPlayerAnimationType() {
        return playerAction;
    }

    public void setPlayerAnimationType(PlayerAction playerAction) {
        this.playerAction = playerAction;
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

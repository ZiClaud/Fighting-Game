package characters;

import actions.PlayerAction;

import java.awt.image.BufferedImage;

public class PlayerImage {
    private BufferedImage img;
    private PlayerAction playerAction = PlayerAction.Idle;

    public PlayerAction getPlayerAction() {
        return playerAction;
    }

    public void setPlayerAnimationType(PlayerAction playerAction) {
        this.playerAction = playerAction;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}

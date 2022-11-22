package characters;

import actions.ActionType;

import java.awt.image.BufferedImage;

public class PlayerImage {
    private BufferedImage img;
    private ActionType actionType = ActionType.Idle;

    public void setPlayerAnimationType(ActionType actionType) {
        this.actionType = actionType;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}

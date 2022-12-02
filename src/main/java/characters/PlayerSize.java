package characters;

import actions.imgsFactory.Skin;
import utils.MyUtils;

/**
 * Image stats: <p>
 * ImgWidth: 200px <p>
 * ImgHeight:200px <p>
 * <p>
 * ActualWidth: 37px <p>
 * ActualHeight: 52px <p>
 * <p>
 * WidthToRemoveFromLeft: 76px <p>
 * WidthToRemoveFromRight: 87px <p>
 * HeightToRemoveFromBottom: 78px <p>
 * HeightToRemoveFromTop: 70px <p>
 */
public class PlayerSize implements PlayerSizeInt {
    private final int actualWidth;
    private final int actualHeight;
    private int imgWidth;
    private int imgHeight;
    private int excessiveLeft = 0;
    private int excessiveRight = 0;
    private int excessiveBottom = 0;
    private int excessiveTop = 0;

    public PlayerSize(Skin skin) {

        if (skin == Skin.Spirit) {
            imgWidth = 200;
            imgHeight = 200;

            actualWidth = 37;
            actualHeight = 52;

            excessiveLeft = 76;
            excessiveRight = 87;
            excessiveBottom = 78;
            excessiveTop = 70;
        } else if (skin == Skin.Devil) {
            imgWidth = 200;
            imgHeight = 200;

            actualWidth = 33;
            actualHeight = 56;

            excessiveLeft = 86;
            excessiveRight = 81;
            excessiveBottom = 71;
            excessiveTop = 73;
        } else if (skin == Skin.Undead) {
            imgWidth = 100;
            imgHeight = 100;

            actualWidth = 45;
            actualHeight = 62;

            excessiveLeft = 34;
            excessiveRight = 21;
            excessiveBottom = 17;
            excessiveTop = 21;
        } else if (skin == Skin.Punk) {
            imgWidth = 96;
            imgHeight = 63;

            actualWidth = 28;
            actualHeight = 50;

            excessiveLeft = 37;
            excessiveRight = 31;
            excessiveBottom = 0;
            excessiveTop = 13;
        } else if (skin == Skin.BrawlerGirl) {
            imgWidth = 96;
            imgHeight = 63;

            actualWidth = 24;
            actualHeight = 46;

            excessiveLeft = 33;
            excessiveRight = 39;
            excessiveBottom = 0;
            excessiveTop = 17;
        } else {
            MyUtils.printSkinNotFound();
            actualWidth = 1;
            actualHeight = 1;
        }
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public int getActualWidth() {
        return actualWidth;
    }

    public int getActualHeight() {
        return actualHeight;
    }

    public int getExcessiveLeft() {
        return excessiveLeft;
    }

    public int getExcessiveRight() {
        return excessiveRight;
    }

    public int getExcessiveBottom() {
        return excessiveBottom;
    }

    public int getExcessiveTop() {
        return excessiveTop;
    }

    public int getActualX(int x) {
        return x + getExcessiveLeft();
    }

    public int getActualRightX(int x) {
        return x + getImgWidth() - getExcessiveRight();
    }

    public int getActualY(int y) {
        return y + getExcessiveTop();
    }

    public int getActualBottomY(int y) {
        return y + getImgHeight() - getExcessiveBottom();
    }

    @Override
    public int getMiddleX(int getActualX) {
        return ((getActualX + imgWidth) / 2);
    }

    @Override
    public int getMiddleY(int getActualY) {
        return ((getActualY + imgHeight) / 2);
    }

    @Override
    public String toString() {
        return "PlayerSize{" +
                "imgWidth=" + imgWidth +
                ", imgHeight=" + imgHeight +
                ", actualWidth=" + actualWidth +
                ", actualHeight=" + actualHeight +
                ", widthToRemoveFromLeft=" + excessiveLeft +
                ", widthToRemoveFromRight=" + excessiveRight +
                ", heightToRemoveFromBottom=" + excessiveBottom +
                ", heightToRemoveFromTop=" + excessiveTop +
                '}';
    }
}

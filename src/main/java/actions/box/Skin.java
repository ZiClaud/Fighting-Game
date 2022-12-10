package actions.box;

/**
 * Image stats: Spirit <p>
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
public enum Skin {
    Spirit(200 * 2, 200 * 2, 37 * 2, 52 * 2, 76 * 2, 87 * 2, 78 * 2, 70 * 2, 76 * 2),
    Devil(200 * 2, 200 * 2, 33 * 2, 56 * 2, 86 * 2, 81 * 2, 71 * 2, 73 * 2, 68 * 2),
    Undead(100, 100, 45, 62, 34, 21, 17, 21, 30),

    Punk(96, 63, 28, 50, 37, 31, 0, 13, 22),

    BrawlerGirl(96, 63, 24, 46, 33, 39, 0, 17, 23);

    private final int imgWidth;
    private final int imgHeight;
    private final int actualWidth;
    private final int actualHeight;
    private final int excessiveLeft;
    private final int excessiveRight;
    private final int excessiveBottom;
    private final int excessiveTop;
    private final int damageWidth;

    private final CharacterWidthHeight imgWH;
    private final CharacterWidthHeight actualImgWH;
    private final CharacterWidthHeight damageLeftWH;
    private final CharacterWidthHeight damageRightWH;


    Skin(final int imgWidth, final int imgHeight, final int actualWidth, final int actualHeight, final int excessiveLeft, final int excessiveRight, final int excessiveBottom, final int excessiveTop, final int damageWidth) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;

        this.actualWidth = actualWidth;
        this.actualHeight = actualHeight;

        this.excessiveLeft = excessiveLeft;
        this.excessiveRight = excessiveRight;
        this.excessiveBottom = excessiveBottom;
        this.excessiveTop = excessiveTop;

        this.damageWidth = damageWidth;

        imgWH = new CharacterWidthHeight(imgWidth, imgHeight, 0, 0);
        actualImgWH = new CharacterWidthHeight(actualWidth, actualHeight, excessiveLeft, excessiveTop);
        damageLeftWH = new CharacterWidthHeight(actualWidth + damageWidth, actualHeight, excessiveLeft, excessiveTop);
        damageRightWH = new CharacterWidthHeight(actualWidth + damageWidth, actualHeight, excessiveLeft - damageWidth, excessiveTop);
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

    public int getDamageWidth() {
        return damageWidth;
    }


    public int getMiddleX(int getActualX) {
        return (getActualX + (imgWidth / 2));
    }

    public int getMiddleY(int getActualY) {
        return (getActualY + (imgHeight / 2));
    }


    public CharacterWidthHeight getImgWH() {
        return imgWH;
    }

    public CharacterWidthHeight getActualImgWH() {
        return actualImgWH;
    }

    public CharacterWidthHeight getDamageLeftWH() {
        return damageLeftWH;
    }

    public CharacterWidthHeight getDamageRightWH() {
        return damageRightWH;
    }
}

package characters;

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
public class PlayerSize {
    private final int imgWidth;
    private final int imgHeight;

    private final int actualWidth;
    private final int actualHeight;

    private int widthToRemoveFromLeft = 0;
    private int widthToRemoveFromRight = 0;
    private int heightToRemoveFromBottom = 0;
    private int heightToRemoveFromTop = 0;

    public PlayerSize(int playerWidth, int playerHeight) {
        imgWidth = playerWidth;
        imgHeight = playerHeight;
        if (imgWidth == 200 && imgHeight == 200) {
            actualWidth = 37;
            actualHeight = 52;

            widthToRemoveFromLeft = 76;
            widthToRemoveFromRight = 87;
            heightToRemoveFromBottom = 78;
            heightToRemoveFromTop = 70;
        } else {
            actualWidth = imgWidth;
            actualHeight = imgHeight;
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

    public int getWidthToRemoveFromLeft() {
        return widthToRemoveFromLeft;
    }
    public int getWidthToAddFromRight() {
        return actualWidth - widthToRemoveFromRight;
    }
    public int getHeightToRemoveFromBottom() {
        return actualHeight - heightToRemoveFromBottom;
    }
    public int getHeightToAddFromTop() {
        return heightToRemoveFromTop;
    }
}

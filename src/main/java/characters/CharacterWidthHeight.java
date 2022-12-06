package characters;

public class CharacterWidthHeight {
    private final int width;
    private final int height;
    private final int excessiveWidth;
    private final int excessiveHeight;


    public CharacterWidthHeight(int width, int height, int excessiveWidth, int excessiveHeight) {
        this.width = width;
        this.height = height;
        this.excessiveWidth = excessiveWidth;
        this.excessiveHeight = excessiveHeight;
    }

    public int getX(int x) {
        return x + excessiveWidth;
    }

    public int getY(int y) {
        return y + excessiveHeight;
    }

    public int getXPlusWidth(int x) {
        return x + excessiveWidth + width;
    }

    public int getYPlusHeight(int y) {
        return y + excessiveHeight + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "CharacterWidthHeight{" +
//                "width=" + width +
//                ", height=" + height +
//                ", excessiveWidth=" + excessiveWidth +
//                ", excessiveHeight=" + excessiveHeight +
                ", getXPlusWidthAs0=" + getXPlusWidth(0) +
                ", getYPlusHeightAs0=" + getYPlusHeight(0) +
                '}';
    }
}

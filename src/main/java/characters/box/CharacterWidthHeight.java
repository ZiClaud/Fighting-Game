package characters.box;

public class CharacterWidthHeight {
    protected final int width;
    protected final int height;
    protected final int excessiveWidth;
    protected final int excessiveHeight;


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

    public int getExcessiveWidth() {
        return excessiveWidth;
    }

    public int getExcessiveHeight() {
        return excessiveHeight;
    }
}

package characters;

public class Rectangle {
    private int x;
    private int y;
    private int xPlusWidth;
    private int yPlusHeight;

    public Rectangle(int x, int y, int xPlusWidth, int yPlusHeight) {
        this.x = x;
        this.y = y;
        this.xPlusWidth = xPlusWidth;
        this.yPlusHeight = yPlusHeight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXPlusWidth() {
        return xPlusWidth;
    }

    public int getYPlusHeight() {
        return yPlusHeight;
    }

    public void moveRectangle(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
        this.xPlusWidth = this.xPlusWidth + x;
        this.yPlusHeight = this.yPlusHeight + y;

        if (xPlusWidth < x || yPlusHeight < y) {
            throw new RuntimeException("Rectangle XPlusWidth is less than X or YPlusHeight is less than Y");
        }
    }

    public void moveRectangleToPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

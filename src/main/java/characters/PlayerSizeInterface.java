package characters;

public interface PlayerSizeInterface {
    int getImgWidth();

    int getImgHeight();

    int getActualWidth();

    int getActualHeight();

    int getExcessiveLeft();

    int getExcessiveRight();

    int getExcessiveBottom();

    int getExcessiveTop();

    int getActualX(int x);

    int getActualRightX(int x);

    int getActualY(int y);

    int getActualBottomY(int y);
}

package characters;

import characters.box.CharacterWidthHeight;

public interface PlayerSizeInt {
    CharacterWidthHeight getImgWH();
    CharacterWidthHeight getActualImgWH();
    CharacterWidthHeight getDamageRightWH();
    CharacterWidthHeight getDamageLeftWH();

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

    int getMiddleX(int getActualX);

    int getMiddleY(int getActualY);
    int getDamageWidth();
}

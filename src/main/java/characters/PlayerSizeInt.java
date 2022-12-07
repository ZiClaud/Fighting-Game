package characters;

import characters.box.CharacterWidthHeight;

public interface PlayerSizeInt {
    CharacterWidthHeight getImgWH();

    CharacterWidthHeight getActualImgWH();

    CharacterWidthHeight getDamageRightWH();

    CharacterWidthHeight getDamageLeftWH();

    int getExcessiveLeft();

    int getExcessiveRight();

    int getExcessiveBottom();

    int getExcessiveTop();

    int getMiddleX(int getActualX);

    int getMiddleY(int getActualY);
}

import characters.box.CharacterWidthHeight;
import org.junit.jupiter.api.Test;
import utils.MyUtils;

public class CollisionTest {
    /*
     @Test
     public void collideRect() {
         // 1 1 4 4 - 2 2 2 2
         assert (MyUtils.collideRect(new Rectangle(1, 1, 3, 3), new Rectangle(2, 2, 2, 2)));
         assert (!MyUtils.collideRect(new Rectangle(1, 1, 3, 3), new Rectangle(3, 3, 3, 3)));
         assert (MyUtils.collideRect(new Rectangle(2, 2, 2, 2), new Rectangle(1, 1, 3, 3)));
         assert (MyUtils.collideRect(new Rectangle(2, 2, 5, 5), new Rectangle(4, 4, 6, 6)));
     }
 */
    @Test
    public void collideW() {
        // 1 1 4 4 - 2 2 2 2
        CharacterWidthHeight c1 = new CharacterWidthHeight(20, 20, 0, 0);
        CharacterWidthHeight c2 = new CharacterWidthHeight(10, 1, 0, 0);

        assert (!MyUtils.collideW(c1, c2, 0, 30));
        assert (MyUtils.collideW(c1, c2, 0, 0));
        assert (MyUtils.collideW(c1, c2, 0, 1));
        assert (MyUtils.collideW(c1, c2, 1, 0));
        assert (MyUtils.collideW(c1, c2, 0, 19));
        assert (!MyUtils.collideW(c1, c2, 0, 20));
        assert (!MyUtils.collideW(c1, c2, 0, 21));

        MyUtils.drawCW(new CharacterWidthHeight(1, 1, 0, 0), 0);
        MyUtils.drawCW(new CharacterWidthHeight(2, 2, 2, 2), 0);

        MyUtils.drawCW(new CharacterWidthHeight(1, 1, 0, 0), 0);
        MyUtils.drawCW(new CharacterWidthHeight(2, 2, 2, 2), 0);


        System.out.println("One");

        assert (!MyUtils.collideW(
                new CharacterWidthHeight(1, 1, 0, 0),
                new CharacterWidthHeight(2, 2, 2, 2),
                0, 0));
        System.out.println("Two");

        assert (!MyUtils.collideWH(new CharacterWidthHeight(1, 1, 0, 0),
                0, 0,
                new CharacterWidthHeight(2, 2, 2, 2),
                0, 0));
        System.out.println("Three");

        MyUtils.drawCW(new CharacterWidthHeight(1, 1, 0, 0), 1);
        MyUtils.drawCW(new CharacterWidthHeight(3, 3, 2, 2), 0);

        MyUtils.drawCW(new CharacterWidthHeight(1, 1, 0, 0), 1);
        MyUtils.drawCW(new CharacterWidthHeight(3, 3, 2, 2), 0);

        assert (!MyUtils.collideWH(new CharacterWidthHeight(1, 1, 0, 0),
                1, 1,
                new CharacterWidthHeight(3, 3, 2, 2),
                0, 0));
    }
}

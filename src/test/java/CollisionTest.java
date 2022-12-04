import characters.Rectangle;
import org.junit.jupiter.api.Test;
import utils.MyUtils;

public class CollisionTest {
    @Test
    public void collideRect() {
        // 1 1 4 4 - 2 2 2 2
        assert (MyUtils.collideRect(new Rectangle(1, 1, 3, 3), new Rectangle(2, 2, 2, 2)));
        assert (!MyUtils.collideRect(new Rectangle(1, 1, 3, 3), new Rectangle(3, 3, 3, 3)));
        assert (MyUtils.collideRect(new Rectangle(2, 2, 2, 2), new Rectangle(1, 1, 3, 3)));
        assert (MyUtils.collideRect(new Rectangle(2, 2, 5, 5), new Rectangle(4, 4, 6, 6)));
    }
}

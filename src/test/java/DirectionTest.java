import org.junit.jupiter.api.Test;
import rover.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    void testLeft() {
        assertEquals(Direction.W, Direction.N.left());
        assertEquals(Direction.S, Direction.W.left());
        assertEquals(Direction.E, Direction.S.left());
        assertEquals(Direction.N, Direction.E.left());
    }

    @Test
    void testRight() {
        assertEquals(Direction.E, Direction.N.right());
        assertEquals(Direction.S, Direction.E.right());
        assertEquals(Direction.W, Direction.S.right());
        assertEquals(Direction.N, Direction.W.right());
    }
}

import org.junit.jupiter.api.Test;
import rover.Direction;
import rover.Rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    void testMove() {
        Rover rover = new Rover(1, 2, Direction.N);
        rover.move();
        assertEquals(3, rover.getY());
        assertEquals(1, rover.getX());
    }

    @Test
    void testRotateLeft() {
        Rover rover = new Rover(1, 2, Direction.N);
        rover.rotateLeft();
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void testRotateRight() {
        Rover rover = new Rover(1, 2, Direction.N);
        rover.rotateRight();
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void testToString() {
        Rover rover = new Rover(1, 2, Direction.N);
        assertEquals("1 2 N", rover.toString());
    }
}

import org.junit.jupiter.api.Test;
import rover.Direction;
import rover.Rover;
import rover.RoverController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverControllerTest {
    @Test
    void testProcessCommands() {
        RoverController controller = new RoverController(5, 5);
        Rover rover = new Rover(1, 2, Direction.N);

        controller.processCommands(rover, "LMLMLMLMM");

        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    void testOutOfBounds() {
        RoverController controller = new RoverController(5, 5);
        Rover rover = new Rover(5, 5, Direction.N);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.processCommands(rover, "M"); // Devrait sortir du plateau
        });

        assertEquals("Rover out of bounds!", exception.getMessage());
    }


}

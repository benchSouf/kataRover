package rover;

public class RoverController {
    int Xmax, Ymax;

    public RoverController(int Xmax, int Ymax) {
        this.Xmax = Xmax;
        this.Ymax = Ymax;
    }

    public void processCommands(Rover rover, String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> rover.rotateLeft();
                case 'R' -> rover.rotateRight();
                case 'M' -> {
                    rover.move();
                    if (!isValidPosition(rover)) {
                        throw new IllegalArgumentException("Rover out of bounds!");
                    }
                }
            }
        }
    }

    private boolean isValidPosition(Rover rover) {
        return rover.x >= 0 && rover.x <= Xmax && rover.y >= 0 && rover.y <= Ymax;
    }
}

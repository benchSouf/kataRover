package rover;

public class RoverController {
   private int Xmax, Ymax;

    public RoverController(int Xmax, int Ymax) {
        this.Xmax = Xmax;
        this.Ymax = Ymax;
    }
    public int getXmax() { return Xmax; }
    public int getYmax() { return Ymax; }

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
        return rover.getX() >= 0 && rover.getX() <= Xmax && rover.getY() >= 0 && rover.getY() <= Ymax;
    }
}

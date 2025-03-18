package rover;

public class Rover {
    int x, y;
    Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }

    public void move() {
        switch (direction) {
            case N -> y++;
            case E -> x++;
            case S -> y--;
            case W -> x--;
        }
    }

    public void rotateLeft() {
        direction = direction.left();
    }

    public void rotateRight() {
        direction = direction.right();
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}

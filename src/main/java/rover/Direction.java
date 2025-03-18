package rover;

import java.util.Map;

public enum Direction {
    N, E, S, W;

    // Mappings pour la rotation gauche et droite
    private static final Map<Direction, Direction> LEFT_MAP = Map.of(
            N, W,
            W, S,
            S, E,
            E, N
    );

    private static final Map<Direction, Direction> RIGHT_MAP = Map.of(
            N, E,
            E, S,
            S, W,
            W, N
    );

    // Tourne à gauche
    public Direction left() {
        return LEFT_MAP.get(this);
    }

    // Tourne à droite
    public Direction right() {
        return RIGHT_MAP.get(this);
    }
}

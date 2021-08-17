package src;

import java.awt.Point;
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public Point translate() {
        switch (this) {
            case UP:
                return new Point(0, -4);
            case DOWN:
                return new Point(0, 4);
            case LEFT:
                return new Point(-4, 0);
            case RIGHT:
                return new Point(4, 0);
            default:
                throw new IllegalStateException("Impossible");
        }
    }
}

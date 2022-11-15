package ca.bcit.comp2522.termproject.vnj.BackToNature;

import java.util.Objects;

/**
 * A point location in the game.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * A Point constructor.
     *
     * @param x a double
     * @param y a double
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value of x-coordinate.
     *
     * @return x as an int
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the value of the y-coordinate.
     *
     * @return y as an int
     */
    public int getY() {
        return y;
    }

    /**
     * Creates a string description of the Point instance.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }

    /**
     * Checks true if the object is a type of Point.
     *
     * @param object an object that is being checked.
     * @return true if object is of type Point
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return x == point.x && y == point.y;
    }

    /**
     * Creates a hashcode that uniquely identifies the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

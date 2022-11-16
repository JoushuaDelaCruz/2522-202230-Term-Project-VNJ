package ca.bcit.comp2522.termproject.vnj.BackToNature.Character;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Point;

import java.util.Objects;

/**
 * A Character.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public abstract class Character {
    /**
     * List of four direction that a character may be facing.
     */
    public enum Direction {
        North, South, East, West
    }
    /**
     * The name of the character.
     */
    protected String name;
    /**
     * Location of the character.
     */
    protected Point location;
    /**
     * The direction the character is facing.
     */
    protected Direction direction;

    /**
     * A Character constructor.
     *
     * @param name the name of the character
     * @param location starting location of the character.
     * @throws IllegalArgumentException when name is invalid
     */
    public Character(final String name, final Point location) {
        if (name != null && name.trim().length() != 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A character must have a name!");
        }
        this.direction = Direction.North;
        this.location = location;
    }

    /**
     * Changes the direction the user is facing.
     *
     * @param newDirection a new direction the character is facing.
     */
    public void changeDirection(final String newDirection) {
        switch (newDirection) {
            case "E" -> this.direction = Direction.East;
            case "W" -> this.direction = Direction.West;
            case "S" -> this.direction = Direction.South;
            default -> this.direction = Direction.North;
        }
    }

    /**
     * Moves the character to new position.
     */
    public void move() {
        int currentX = this.location.getX();
        int currentY = this.location.getY();
        switch (this.direction) {
            case East -> currentX += 1;
            case West -> currentX -= 1;
            case South -> currentY -= 1;
            default -> currentY += 1;
        }
        this.location = new Point(currentX, currentY);
    }

    /**
     * Returns the name of the character.
     *
     * @return a name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current location of the character.
     *
     * @return location as a String
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Returns the direction the character is currently facing.
     *
     * @return direction as a String.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Checks if object is f type Character.
     *
     * @param object an object to check.
     * @return true if object of type Character
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Character character = (Character) object;
        return name.equals(character.name) && location.equals(character.location) && direction == character.direction;
    }

    /**
     * Creates an int that uniquely identifies the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, location, direction);
    }

    /**
     * Returns a string description of the instance.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", location=" + location
                + ", direction=" + direction
                + '}';
    }
}

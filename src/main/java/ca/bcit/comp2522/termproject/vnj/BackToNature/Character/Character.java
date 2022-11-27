package ca.bcit.comp2522.termproject.vnj.BackToNature.Character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Point;
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
     * Default number of units the character moves.
     */
    public static final int MOVEMENT_IN_UNITS = 10;
    /**
     * Default number that is associated with North.
     */
    public static final int NORTH = 1;
    /**
     * Default number that is associated with SOUTH.
     */
    public static final int SOUTH = 2;
    /**
     * Default number that is associated with EAST.
     */
    public static final int EAST = 3;
    /**
     * Default number that is associated with WEST.
     */
    public static final int WEST = 4;
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
     * The holds the images of the character.
     */
    protected final ImageView image;
    private boolean spriteMovement;
    /**
     * A Character constructor.
     *
     * @param name the name of the character
     * @param location starting location of the character.
     * @param url the url location of the image
     * @throws IllegalArgumentException when name or url is invalid
     */
    public Character(final String name, final Point location, final String url) {
        if (name != null && name.trim().length() != 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A character must have a name!");
        }
        if (url != null && url.trim().length() != 0) {
            this.image = new ImageView(new Image(url, true));
            image.setX(location.x);
            image.setY(location.y);
        } else {
            throw new IllegalArgumentException("A character must have a name!");
        }
        this.direction = Direction.North;
        this.location = location;
    }

    /**
     * Moves the character to new position.
     *
     * @param move the default number that is associated with direction.
     */
    public void move(final int move) {
        spriteMovement = !spriteMovement;
        switch (move) {
            case NORTH -> {
                draw(NORTH);
                image.setY(image.getY() - MOVEMENT_IN_UNITS);
                direction = Direction.North;
            }
            case SOUTH -> {
                draw(SOUTH);
                image.setY(image.getY() + MOVEMENT_IN_UNITS);
                direction = Direction.South;
            }
            case EAST -> {
                draw(EAST);
                image.setX(image.getX() + MOVEMENT_IN_UNITS);
                direction = Direction.East;
            }
            case WEST -> {
                draw(WEST);
                image.setX(image.getX() - MOVEMENT_IN_UNITS);
                direction = Direction.West;
            }
            default -> { }
        }
    }

    private void draw(final int directionImage) {
        switch (directionImage) {
            case NORTH -> {
                if (spriteMovement) {
                    image.setImage(new Image("FacingBackwards1.png"));
                } else {
                    image.setImage(new Image("FacingBackwards2.png"));
                }
            }
            case SOUTH -> {
                if (spriteMovement) {
                    image.setImage(new Image("FacingForward1.png"));
                } else {
                    image.setImage(new Image("FacingForward2.png"));
                }
            }
            case EAST -> {
                if (spriteMovement) {
                    image.setImage(new Image("FacingRightSprite1.png"));
                } else {
                    image.setImage(new Image("FacingRightSprite2.png"));
                }
            }
            case WEST -> {
                if (spriteMovement) {
                    image.setImage(new Image("FacingLeft1.png"));
                } else {
                    image.setImage(new Image("FacingLeft2.png"));
                }
            }
            default -> { }
        }
    }

    /**
     * Returns the image view of the character.
     *
     * @return image as an imageView node
     */
    public ImageView getImageView() {
        return image;
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

package ca.bcit.comp2522.termproject.vnj.BackToNature.Character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Point;
import java.util.Objects;

/**
 * A Character.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public abstract class Character {
    /**
     * Default number of units the character moves.
     */
    public static final int MOVEMENT_IN_UNITS = 15;
    /**
     * The number seconds the next movement of a character will occur.
     */
    public static final int SECONDS_TO_MOVE = 10;
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
    protected int direction;
    /**
     * The holds the images of the character.
     */
    protected final ImageView image;
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private boolean spriteMovement;
    private int spriteCounter;
    private final int screenWidth;
    private final int screenHeight;

    /**
     * A Character constructor.
     *
     * @param name     the name of the character
     * @param location starting location of the character.
     * @param url      the url location of the image
     * @param screenHeight the height of the screen
     * @param screenWidth the width of the screen
     * @throws IllegalArgumentException when name or url is invalid
     */
    public Character(final String name, final Point location, final String url,
                     final int screenWidth, final int screenHeight) {
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
        if (screenWidth > 0 && screenHeight > 0) {
            this.screenWidth = screenWidth;
            this.screenHeight = screenHeight;
        } else {
            throw new IllegalArgumentException("A character must know the boundaries!");
        }
        this.location = location;
    }

    /**
     * Moves the character to new position.
     */
    public void move() {
        spriteCounter++;
        spriteMovement = !spriteMovement;
        if (spriteCounter > SECONDS_TO_MOVE) {
            spriteCounter = 0;
            if (isMovingUp) {
                userMoving(NORTH);
            }
            if (isMovingDown) {
                userMoving(SOUTH);
            }
            if (isMovingLeft) {
                userMoving(WEST);
            }
            if (isMovingRight) {
                userMoving(EAST);
            }
        }
    }

    /**
     * Resets the movements into false and resets the image of the user into a standing sprite.
     */
    public void resetMovements() {
        if (isMovingUp) {
            isMovingUp = false;
            image.setImage(new Image("FacingBackwardSprite.png"));
        }
        if (isMovingDown) {
            isMovingDown = false;
            image.setImage(new Image("FacingForwardSprite.png"));
        }
        if (isMovingLeft) {
            isMovingLeft = false;
            image.setImage(new Image("FacingLeftSprite.png"));
        }
        if (isMovingRight) {
            isMovingRight = false;
            image.setImage(new Image("FacingRightSprite.png"));
        }
    }
    private void userMoving(final int moveDirection) {
        draw(moveDirection);
        switch (moveDirection) {
            case NORTH -> {
                if (image.getY() > 0) {
                    image.setY(image.getY() - MOVEMENT_IN_UNITS);
                }
            }
            case SOUTH -> {
                if (image.getY() < this.screenHeight) {
                    image.setY(image.getY() + MOVEMENT_IN_UNITS);
                }
            }
            case EAST -> {
                if (image.getX() < this.screenWidth) {
                    image.setX(image.getX() + MOVEMENT_IN_UNITS);
                }
            }
            case WEST -> {
                if (image.getX() > 0) {
                    image.setX(image.getX() - MOVEMENT_IN_UNITS);
                }
            }
            default -> {
            }
        }
        this.direction = moveDirection;
    }

    private void draw(final int userDirection) {
        switch (userDirection) {
            case NORTH -> drawSpriteBackward();
            case SOUTH -> drawSpriteForward();
            case EAST -> drawSpriteRight();
            case WEST -> drawSpriteLeft();
            default -> {
            }
        }
    }

    private void drawSpriteBackward() {
        if (spriteMovement) {
            image.setImage(new Image("FacingBackwards1.png"));
        } else {
            image.setImage(new Image("FacingBackwards2.png"));
        }
    }

    private void drawSpriteForward() {
        if (spriteMovement) {
            image.setImage(new Image("FacingForward1.png"));
        } else {
            image.setImage(new Image("FacingForward2.png"));
        }
    }

    private void drawSpriteRight() {
        if (spriteMovement) {
            image.setImage(new Image("FacingRightSprite1.png"));
        } else {
            image.setImage(new Image("FacingRightSprite2.png"));
        }
    }

    private void drawSpriteLeft() {
        if (spriteMovement) {
            image.setImage(new Image("FacingLeft1.png"));
        } else {
            image.setImage(new Image("FacingLeft2.png"));
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
     * Returns the direction the character is currently facing.
     *
     * @return direction as an int.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Sets the isMovingUp to either true or false.
     *
     * @param movingUp either true or false
     */
    public void setMovingUp(final boolean movingUp) {
        isMovingUp = movingUp;
    }
    /**
     * Sets the isMovingDown to either true or false.
     *
     * @param movingDown either true or false
     */
    public void setMovingDown(final boolean movingDown) {
        isMovingDown = movingDown;
    }
    /**
     * Sets the isMovingLeft to either true or false.
     *
     * @param movingLeft either true or false
     */
    public void setMovingLeft(final boolean movingLeft) {
        isMovingLeft = movingLeft;
    }
    /**
     * Sets the isMovingRight to either true or false.
     *
     * @param movingRight either true or false
     */
    public void setMovingRight(final boolean movingRight) {
        isMovingRight = movingRight;
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

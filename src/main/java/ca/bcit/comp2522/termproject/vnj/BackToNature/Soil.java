package ca.bcit.comp2522.termproject.vnj.BackToNature;

import javafx.scene.image.Image;

import java.util.Objects;

/**
 * Soil.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Soil {
    /**
     * Default tile size of the game in pixels.
     */
    public static final int ORIGINAL_TILE_SIZE = 16; // 16x16 tile
    /**
     * Default scale to accommodate with any screen resolutions. (To make images bigger)
     */
    public static final int SCALE = 3;
    /**
     * Default number for the tile size on the game.
     */
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48 tile
    private Image image;
    private final boolean isFence;
    private boolean isTill;
    private boolean isWatered;

    /**
     * Constructor of an object of type Soil.
     *
     * @param url the url of the image
     * @param isFence whether the soil is a border or not.
     * @throws IllegalArgumentException if the soil does not have an image!
     */
    public Soil(final String url, final boolean isFence) {
        if (url != null && url.trim().length() != 0) {
            this.image = new Image(url, TILE_SIZE, TILE_SIZE, false, true);
        } else {
            throw new IllegalArgumentException("A soil must have an image!");
        }
        this.isFence = isFence;
        this.isTill = false;
        this.isWatered = false;
    }

    /**
     * Returns the image view stored in the tile.
     *
     * @return image as an Image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Returns if the tile isFence or not.
     *
     * @return isFence as a boolean
     */
    public boolean getIsFence() {
        return !isFence;
    }
    /**
     * Updates the image stored in the image variable.
     *
     * @param imageUrl the url of the image
     */
    public void setImage(final String imageUrl) {
        this.image = new Image(imageUrl, TILE_SIZE, TILE_SIZE, false, true);
    }

    /**
     * Returns the till state of the soil.
     *
     * @return true if it till, else false
     */
    public boolean getIsTill() {
        return isTill;
    }

    /**
     * Returns if soil is watered or not.
     *
     * @return true if it is watered else false
     */
    public boolean getIsWatered() {
        return isWatered;
    }

    /**
     * Water state of the soil.
     *
     * @param isWateredSoil weather the soil is dry or not
     */
    public void water(final boolean isWateredSoil) {
        this.isWatered = isWateredSoil;
    }

    /**
     * Tills the soil.
     *
     * @param isTillSoil weather the soil untills or not.
     */
    public void till(final boolean isTillSoil) {
        this.isTill = isTillSoil;
    }

    /**
     * Returns the description of a soil.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Soil{"
                + "till=" + isTill
                + ", water=" + isWatered
                + '}';
    }

    /**
     * Checks if an object is of type Soil.
     *
     * @param object an object
     * @return true if an object is of type Soil
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Soil soil = (Soil) object;
        return isTill == soil.isTill && isWatered == soil.isWatered;
    }

    /**
     * Returns an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(isTill, isWatered);
    }
}

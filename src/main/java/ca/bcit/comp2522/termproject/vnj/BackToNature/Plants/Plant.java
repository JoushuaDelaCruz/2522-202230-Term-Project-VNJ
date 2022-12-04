package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

import java.util.Objects;

/**
 * Crop Class. When growing a plant, in this version, there are three stages
 * seed, budding and ripening. By default, the plant starts as a seed.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public abstract class Plant {
    /**
     * Stages of a crop.
     */
    public enum Growth {
        seed, budding, ripe
    }
    /**
     * Default start date of the crop being planted.
     */
    public static final int START_PLANTED = 0;
    /**
     * The number of days the crops has been planted.
     */
    protected int days;

    /**
     * The current growth stage of the plant.
     */
    protected Growth stage;
    /**
     * Weather the plant is wilted or not.
     */
    protected boolean isWilted;
    /**
     * Constructs an object of type crop.
     *
     * @throws IllegalArgumentException when price is below 0
     */
    public Plant() {
        this.days = START_PLANTED;
        this.stage = Growth.seed;
        this.isWilted = false;
    }

    /**
     * Returns the number of days the plant has been planted.
     *
     * @return days as an int
     */
    public int getDays() {
        return days;
    }

    /**
     * Returns true if plant is in budding stage.
     *
     * @return true if plant is budding
     */
    public boolean isBudding() {
        return stage == Growth.budding;
    }

    /**
     * Returns true if plant is ripe.
     *
     * @return if plant is ripe.
     */
    public boolean isRipening() {
        return stage == Growth.ripe;
    }

    /**
     * Returns true if the plant is wilted, else false.
     *
     * @return if the plant is still alive.
     */
    public boolean getIsWilted() {
        return isWilted;
    }

    /**
     * Sets the plant to wilt state.
     */
    public void wilt() {
        isWilted = true;
    }
    /**
     * Increments day and grows the plant to a new stage.
     */
    public void grow() {
        this.days++;
    }
    /**
     * Returns a description of a Crop object.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Crop{"
                + "days=" + days
                + '}';
    }

    /**
     * Checks if an object is identical to the instance.
     *
     * @param object an object
     * @return true if an object is the same as the instance
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Plant plant = (Plant) object;
        return days == plant.days && stage == plant.stage;
    }

    /**
     * Creates a hashcode associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(days, stage);
    }
}

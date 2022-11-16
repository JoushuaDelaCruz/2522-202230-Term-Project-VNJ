package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

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
     * Constructs an object of type crop.
     *
     * @throws IllegalArgumentException when price is below 0
     */
    public Plant() {
        this.days = START_PLANTED;
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
     * Increments day and grows the plant to a new stage.
     */
    public void grow() {
        this.days++;
    }

    /**
     * Returns the current stage of the crop.
     *
     * @return stage of the crop as a String.
     */
    public Growth stage() {
        return Growth.budding;
    }

    /**
     * Turns the plant into budding stage.
     */
    protected void budding() {
    }

    /**
     * Turns the crop into ripening stage.
     */
    protected void ripening() {
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
}

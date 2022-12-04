package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

/**
 * Turnip class.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Turnip extends Plant implements Harvestable {
    /**
     * Default price of a turnip crop.
     */
    public static final double DEFAULT_PRICE = 60.00;
    /**
     * Default name of a turnip crop.
     */
    public static final String DEFAULT_CROP_NAME = "Turnip";
    /**
     * Default number of days for the seed to go budding stage.
     */
    public static final int DEFAULT_NUM_TO_BUDDING = 2;
    /**
     * Default number of days for the bud to go ripening stage.
     */
    public static final int DEFAULT_NUM_TO_RIPENING = 4;
    /**
     * Grows the plant into different stages.
     */
    @Override
    public void grow() {
        this.days++;
        if (this.days >= DEFAULT_NUM_TO_BUDDING && this.days <= DEFAULT_NUM_TO_RIPENING) {
            this.stage = Growth.budding;
        }
        if (this.days >= DEFAULT_NUM_TO_RIPENING && !this.isWilted) {
            this.stage = Growth.ripe;
        }
    }
    /**
     * Creates a sellable crop if the plant is in ripening.
     *
     * @return a turnip crop object if the plant is in ripening stage else null
     */
    @Override
    public Crop harvest() {
        if (this.stage == Growth.ripe) {
            class TurnipCrop extends Crop {
                /**
                 * A Crop constructor.
                 *
                 * @throws IllegalArgumentException when price is below 0
                 */
                TurnipCrop() {
                    super(DEFAULT_PRICE, DEFAULT_CROP_NAME);
                }
            }
            return new TurnipCrop();
        }
        return null;
    }
}

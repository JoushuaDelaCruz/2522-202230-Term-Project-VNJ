package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Crop;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Harvestable;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Plant;

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

    @Override
    public void budding() {
    }

    @Override
    public void ripening() {
    }

    /**
     * Creates an instance.
     *
     * @return a Turnip crop
     */
    @Override
    public Crop harvest() {
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
}

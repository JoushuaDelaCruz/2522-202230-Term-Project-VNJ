package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

/**
 * A cucumber plant.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public class Cucumber extends Plant implements ReGrow, Harvestable {
    /**
     * Default price of a turnip crop.
     */
    public static final double DEFAULT_PRICE = 60.00;
    /**
     * Default name of a turnip crop.
     */
    public static final String DEFAULT_CROP_NAME = "Turnip";
    @Override
    public void reRipe() {
    }

    /**
     * Creates an instance.
     *
     * @return a Turnip crop
     */
    @Override
    public Crop harvest() {
        class CucumberCrop extends Crop {
            /**
             * a Crop constructor.
             *
             * @throws IllegalArgumentException when price is below 0
             */
            CucumberCrop() {
                super(DEFAULT_PRICE, DEFAULT_CROP_NAME);
            }
        }
        return new CucumberCrop();
    }
}

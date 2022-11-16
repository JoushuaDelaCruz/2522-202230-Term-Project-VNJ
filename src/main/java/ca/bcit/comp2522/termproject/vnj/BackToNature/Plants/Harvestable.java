package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

/**
 * Harvestable plants.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public interface Harvestable {
    /**
     * Returns the crop from the plant.
     *
     * @return a crop
     */
    Crop harvest();
}

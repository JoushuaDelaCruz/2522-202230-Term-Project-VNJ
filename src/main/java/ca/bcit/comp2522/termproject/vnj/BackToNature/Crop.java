package ca.bcit.comp2522.termproject.vnj.BackToNature;

/**
 * Crop behaviours.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public interface Crop {
    /**
     * Grows the seed to budding stage.
     */
    void budding();

    /**
     * Grows the seed to ripening stage.
     */
    void ripening();

    /**
     * Checks if crops is ripe enough to harvest.
     */
    void harvest();

    /**
     * Returns the stamina gain when eaten.
     *
     * @return the stamina gain as an Int
     */
    int eaten();
}

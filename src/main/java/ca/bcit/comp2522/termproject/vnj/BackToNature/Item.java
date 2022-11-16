package ca.bcit.comp2522.termproject.vnj.BackToNature;

/**
 * Blueprint for Items.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public interface Item {
    /**
     * The item is stored.
     */
    void store();

    /**
     * Returns the stamina cost of the action.
     *
     * @return the stamina cost as an int
     */
    int exhaust();
}

package ca.bcit.comp2522.termproject.vnj.BackToNature.Character;

import java.awt.Point;
import java.io.File;

/**
 * A mayor.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public final class Mayor extends Character implements NonPlayableCharacter {
    /**
     * Default name for the mayor.
     */
    public static final String DEFAULT_MAYOR_NAME = "Chris T.";
    private static Mayor singleInstance = null;
    /**
     * A Character constructor.
     *
     * @param location starting location of the character.
     * @throws IllegalArgumentException when name is invalid
     */
    private Mayor(final Point location) {
        super(DEFAULT_MAYOR_NAME, location, "");
    }

    /**
     * Creates a single instance of Mayor Class.
     *
     * @return a mayor instance
     */
    public static Mayor getInstance() {
        if (singleInstance == null) {
            singleInstance = new Mayor(new Point(0, 0));
        }
        return singleInstance;
    }

    @Override
    public void talk() {

    }

    @Override
    public void getDialogue(final File file) {

    }

    /**
     * Gives the total profit to the user.
     *
     * @return the total profit of the user for the day.
     */
    public double totalProfit() {
        return 0;
    }
}

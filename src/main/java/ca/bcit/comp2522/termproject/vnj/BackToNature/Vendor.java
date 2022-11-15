package ca.bcit.comp2522.termproject.vnj.BackToNature;

import java.io.File;

/**
 * An NPC vendor.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Vendor extends Character implements NonPlayableCharacter {
    /**
     * A Character constructor.
     *
     * @param name the name of the character
     * @param location starting location of the character.
     * @throws IllegalArgumentException when name is invalid
     */
    public Vendor(final String name, final Point location) {
        super(name, location);
    }

    @Override
    public void talk() {

    }

    @Override
    public void getDialogue(final File file) {

    }

    /**
     * Displays the sellable seeds.
     *
     * @return the price of the selected product
     */
    public double sell() {
        System.out.println("Hello!");
        return 0;
        // Adds a while loops, and it returns price amount of the seed chosen
    }
}

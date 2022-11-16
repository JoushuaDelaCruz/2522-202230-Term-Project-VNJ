package ca.bcit.comp2522.termproject.vnj.BackToNature.Land;

import java.util.Objects;

/**
 * Soil.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Soil {
    private boolean till;
    private boolean water;

    /**
     * Constructor of an object of type Soil.
     */
    public Soil() {
        this.till = false;
        this.water = false;
    }

    /**
     * Returns the till state of the soil.
     *
     * @return true if it till, else false
     */
    public boolean getTill() {
        return till;
    }

    /**
     * Returns if soil is watered or not.
     *
     * @return true if it is watered else false
     */
    public boolean getWater() {
        return water;
    }

    /**
     * Water state of the soil.
     *
     * @param isWatered weather the soil is dry or not
     */
    public void water(final boolean isWatered) {
        this.water = isWatered;
    }

    /**
     * Tills the soil.
     *
     * @param isTill weather the soil untills or not.
     */
    public void till(final boolean isTill) {
        this.till = isTill;
    }

    /**
     * Returns the description of a soil.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Soil{"
                + "till=" + till
                + ", water=" + water
                + '}';
    }

    /**
     * Checks if an object is of type Soil.
     *
     * @param object an object
     * @return true if an object is of type Soil
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Soil soil = (Soil) object;
        return till == soil.till && water == soil.water;
    }

    /**
     * Returns an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(till, water);
    }
}

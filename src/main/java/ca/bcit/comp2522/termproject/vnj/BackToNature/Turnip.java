package ca.bcit.comp2522.termproject.vnj.BackToNature;

import java.util.Objects;

/**
 * Turnip class.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Turnip implements Crop {
    /**
     * Default price of turnips.
     */
    public static final double DEFAULT_PRICE = 60.00;
    private final double price;

    /**
     * A default turnip constructor which sets the price into 60.00.
     */
    public Turnip() {
        this(DEFAULT_PRICE);
    }
    /**
     * Constructs a turnip.
     *
     * @param price the money gain if sell
     * @throws IllegalArgumentException when price is lower than 0
     */
    public Turnip(final double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("A turnip must have a price!");
        }
    }
    /**
     * Returns the price of the turnip.
     *
     * @return price as a double
     */
    public double getPrice() {
        return price;
    }

    @Override
    public void budding() {
    }

    @Override
    public void ripening() {
    }

    @Override
    public void harvest() {
    }

    /**
     * Returns the stamina gain when the crop is eaten.
     *
     * @return the stamina gain as a int
     */
    @Override
    public int eaten() {
        return 0;
    }

    /**
     * Returns a string description of a turnip.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Turnip{"
                + "price=" + price
                + '}';
    }

    /**
     * Checks if an object is of type Turnip.
     *
     * @param object an object
     * @return true if object is of type Turnip
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Turnip turnip = (Turnip) object;
        return price == turnip.price;
    }

    /**
     * Returns an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}

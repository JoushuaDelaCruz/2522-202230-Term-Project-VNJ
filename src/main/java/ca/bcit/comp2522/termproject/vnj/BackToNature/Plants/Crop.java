package ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;

import java.util.Objects;

/**
 * Crop class.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public abstract class Crop {
    /**
     * Default invalid starting price.
     */
    public static final double LOWER_PRICE = 0;
    /**
     * Default the shortest length of name.
     */
    public static final int SHORT_LENGTH = 0;
    private final double price;
    private final String name;

    /**
     * a Crop constructor.
     *
     * @param price the amount associated with the crop.
     * @param name the name of the crop
     * @throws IllegalArgumentException when price is below 0
     */
    Crop(final double price, final String name) {
        if (price >= LOWER_PRICE) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("A crop must have a price!");
        }
        if (name != null && name.trim().length() != SHORT_LENGTH) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A crop must have a name!");
        }
    }

    /**
     * Returns the price of the crop.
     *
     * @return price as an int
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the name of the crop.
     *
     * @return price as an int
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a description of the crop.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Crop{"
                + "price=" + price
                + ", name=" + name
                + '}';
    }

    /**
     * Checks if an object is of type Crop.
     *
     * @param object an object
     * @return true if object is of type Crop
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Crop crop = (Crop) object;
        return Double.compare(crop.price, price) == 0 && name.equals(crop.name);
    }

    /**
     * A hashcode associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}

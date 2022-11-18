package ca.bcit.comp2522.termproject.vnj.BackToNature.Inventory;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Crop;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Point;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A shipping bin. Its storage is unlimited
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class ShippingBin {
    private final ArrayList<Crop> crops;
    private int numItems;
    private double profit;
    private final Point location;

    /**
     * Constructs a shipping bin object.
     *
     * @param location the location of the shipping bin
     * @throws IllegalArgumentException when location is null
     */
    public ShippingBin(final Point location) {
        if (location != null) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("A shipping bin must have a location!");
        }
        crops = new ArrayList<>();
    }

    /**
     * Adds the crop to the list and adds the profit as well.
     *
     * @param crop a crop to be shipped
     * @return true if successfully added, else false.
     */
    public boolean addItem(final Crop crop) {
        if (crops.add(crop)) {
            numItems++;
            increaseProfit(crop.getPrice());
            return true;
        }
        return false;
    }

    private void increaseProfit(final double cropProfit) {
         this.profit += cropProfit;
    }

    /**
     * Clears the shipping bin.
     */
    public void clear() {
        crops.clear();
    }

    /**
     * Returns the total number of items in the list.
     *
     * @return numItems as an int
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * Returns the total number of profits in the list.
     *
     * @return profits as a double
     */
    public double getProfit() {
        return profit;
    }

    /**
     * Returns the location of the shipping bin.
     *
     * @return location as Point
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Checks if object is the identical to the instance.
     *
     * @param object an object
     * @return true if an object is identical to the instance
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ShippingBin that = (ShippingBin) object;
        return numItems == that.numItems
                && Double.compare(that.profit, profit) == 0
                && Objects.equals(crops, that.crops)
                && location.equals(that.location);
    }

    /**
     * Returns an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(crops, numItems, profit, location);
    }
}

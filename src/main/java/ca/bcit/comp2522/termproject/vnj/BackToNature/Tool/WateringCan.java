package ca.bcit.comp2522.termproject.vnj.BackToNature.Tool;

import java.util.Objects;

/**
 * A watering can. Use to water the plants and interacts with the soil class
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public final class WateringCan extends Tool implements UtilityTools {
    /**
     * Default minimum amount of water.
     */
    public static final int MINIMUM_WATER = 0;
    /**
     * Default description.
     */
    public static final String DEFAULT_DESCRIPTION = "Use to water crops, and can be filled at any source of water";
    /**
     * Default description.
     */
    public static final int DEFAULT_USAGE = 2;
    /**
     * Default description.
     */
    public static final String DEFAULT_NAME = "Watering Can";
    /**
     * Default maximum amount of water.
     */
    public static final int MAX_WATER = 10;
    private static WateringCan singleInstance = null;
    private int water;

    /**
     * A tool constructor.
     *
     * @throws IllegalArgumentException when description, name or staminaUsage is less than the minimum valid arguments
     */
    public WateringCan() {
        super(DEFAULT_DESCRIPTION, DEFAULT_NAME, DEFAULT_USAGE);
        this.water = MINIMUM_WATER;
    }

    /**
     * Creates a single instance of a Watering Can.
     *
     * @return a WateringCan instance
     */
    public static WateringCan getInstance() {
        if (singleInstance != null) {
            singleInstance = new WateringCan();
        }
        return singleInstance;
    }

    @Override
    public boolean use() {
        if (this.water != MINIMUM_WATER) {
            this.water--;
            return true;
        }
        return false;
    }

    /**
     * Refills the watering can.
     */
    public void refill() {
        this.water = MAX_WATER;
    }

    /**
     * Returns a description of a WateringCan.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "WateringCan{"
                + "water=" + water
                + '}';
    }

    /**
     * Checks if an object is of type WateringCan.
     *
     * @param object an object
     * @return true if an object is of type WateringCan
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        WateringCan that = (WateringCan) object;
        return water == that.water;
    }

    /**
     * Creates an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(water);
    }
}

package ca.bcit.comp2522.termproject.vnj.BackToNature.Tool;
/**
 * Seed.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class Seed extends Tool implements UtilityTools {
    /**
     * Default stamina usage when using any seeds.
     */
    public static final int DEFAULT_STAMINA_USAGE = 1;
    /**
     * Default minimum quantity of a seed.
     */
    public static final int MINIMUM_QUANTITY = 0;
    private int quantity;
    /**
     * A tool constructor.
     *
     * @param description  describes the tool
     * @param name         the name of the tool
     * @param quantity     number of seeds
     * @throws IllegalArgumentException when description, name or staminaUsage is less than the minimum valid arguments
     */
    public Seed(final String description, final String name, final int quantity) {
        super(description, name, DEFAULT_STAMINA_USAGE);
        if (quantity >= MINIMUM_QUANTITY) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("A seed must cost something!");
        }
    }

    /**
     * Plants seeds to the nearest till soil around you. If the soil are not till,
     * it will still be used, there won't be any planted seeds.
     *
     * @return true if there are still seeds left
     */
    @Override
    public boolean use() {
        return this.quantity-- > MINIMUM_QUANTITY;
    }

    /**
     * Adds the quantity of same seed.
     *
     * @param additionalQuantity the quantity of the other seed.
     */
    public void addSeeds(final int additionalQuantity) {
        this.quantity += additionalQuantity;
    }

    /**
     * Returns the quantity usage of the seed.
     *
     * @return quantity as an int.
     */
    public int getQuantity() {
        return quantity;
    }
}

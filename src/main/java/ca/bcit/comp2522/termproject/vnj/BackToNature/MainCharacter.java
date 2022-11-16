package ca.bcit.comp2522.termproject.vnj.BackToNature;

/**
 * Main Character.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public final class MainCharacter extends Character {
    /**
     * Default max stamina.
     */
    public static final int DEFAULT_MAX_STAMINA = 100;
    /**
     * Default starting money.
     */
    public static final double STARTING_MONEY = 250.00;
    /**
     * Default stamina faint state.
     */
    public static final int FAINT_STATE = 0;
    private static MainCharacter singleInstance = null;
    private int stamina;
    private double money;
    /**
     * A Character constructor.
     *
     * @param name the name of the character
     * @param location starting location of the character.
     * @throws IllegalArgumentException when name is invalid
     */
    private MainCharacter(final String name, final Point location) {
        super(name, location);
        this.stamina = DEFAULT_MAX_STAMINA;
        this.money = STARTING_MONEY;
    }

    /**
     * Creates only one single instance of a player.
     *
     * @param name the name of the character
     * @param location starting location
     */
    public void getInstance(final String name, final Point location) {
        if (singleInstance == null) {
            singleInstance = new MainCharacter(name, location);
        }
    }

    /**
     * Buys a product.
     *
     * @param price the amount of money due
     * @return true if current money is enough else false
     */
    public boolean buy(final double price) {
        if (moneyChecker(price)) {
            this.money -= price;
            return true;
        }
        return false;
    }
    private boolean moneyChecker(final double price) {
        return this.money >= price;
    }

    /**
     * Restores the stamina of the user.
     */
    public void restoreStamina() {
        this.stamina = DEFAULT_MAX_STAMINA;
    }

    /**
     * Reduces the stamina of the player to the amount of work exhaustion given.
     *
     * @param staminaCost the exhaustion after using a tool
     */
    public void exhaustion(final int staminaCost) {
        this.stamina -= staminaCost;
    }

    /**
     * Checks if the main character has been pushed too much.
     *
     * @return true if stamina is 0.
     */
    public boolean faint() {
        return this.stamina == FAINT_STATE;
    }

    /**
     * Adds current money to given profit.
     *
     * @param profit earned money
     */
    public void earn(final double profit) {
        this.money += profit;
    }

    /**
     * Returns the current stamina of the main character.
     *
     * @return stamina as an int
     */
    public int getStamina() {
        return this.stamina;
    }

    /**
     * Returns the current money of the main character.
     *
     * @return money as a double
     */
    public double getMoney() {
        return this.money;
    }
}

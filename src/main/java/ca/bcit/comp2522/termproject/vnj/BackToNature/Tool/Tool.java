package ca.bcit.comp2522.termproject.vnj.BackToNature.Tool;

import java.util.Objects;

/**
 * Tool.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public abstract class Tool {
    /**
     * Default minimum length.
     */
    public static final int MINIMUM_LENGTH = 0;
    /**
     * Default minimum stamina usage.
     */
    public static final int MINIMUM_STAMINA_USAGE = 0;
    private final String description;
    private final String name;
    private final int staminaUsage;

    /**
     * A tool constructor.
     *
     * @param description describes the tool
     * @param name the name of the tool
     * @param staminaUsage the cost of stamina when the tool is used
     * @throws IllegalArgumentException when description, name or staminaUsage is less than the minimum valid arguments
     */
    public Tool(final String description, final String name, final int staminaUsage) {
        if (description != null && description.trim().length() > MINIMUM_LENGTH) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("A tool must have a description!");
        }
        if (name != null && name.trim().length() > MINIMUM_LENGTH) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A tool must have a name!");
        }
        if (staminaUsage > MINIMUM_STAMINA_USAGE) {
            this.staminaUsage = staminaUsage;
        } else {
            throw new IllegalArgumentException("A tool must have a stamina usage!");
        }
    }

    /**
     * Returns the description of the tool.
     *
     * @return description as String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the name of the tool.
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the stamina cost when the tool is used.
     *
     * @return staminaUsage as an int
     */
    public int getStaminaUsage() {
        return staminaUsage;
    }

    /**
     * Returns a String description of the object.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "Tool{"
                + "description='" + description + '\''
                + ", name='" + name + '\''
                + ", staminaUsage=" + staminaUsage
                + '}';
    }

    /**
     * Checks if an object is of type Tool.
     *
     * @param object an object
     * @return true if object is of type Tool
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Tool tool = (Tool) object;
        return staminaUsage == tool.staminaUsage && description.equals(tool.description) && name.equals(tool.name);
    }

    /**
     * Returns an int associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, name, staminaUsage);
    }
}

package ca.bcit.comp2522.termproject.vnj.BackToNature.Inventory;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Tool.Tool;

import java.util.*;

/**
 * Tool RuckSack.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class ToolRuckSack {
    /**
     * Default minimum capacity of the rucksack.
     */
    public static final int MINIMUM_CAPACITY = 3;
    /**
     * Default minimum number of tools needed.
     */
    public static final int MINIMUM_NUM_TOOLS = 3;
    /**
     * Default minimum number of words in name.
     */
    public static final int MINIMUM_LENGTH = 0;
    /**
     * Default capacity of the rucksack.
     */
    public static final int DEFAULT_CAPACITY = 5;
    /**
     * Default capacity of the rucksack.
     */
    public static final String DEFAULT_NAME = "Tools";
    private final ArrayList<Tool> tools;
    private final String name;
    private final int capacity;

    /**
     * Constructs a ToolRuckSack.
     *
     * @param tools a list of tools that will be added
     * @param name the name of the rucksack
     * @param capacity the maximum capacity of the rucksack
     * @throws IllegalArgumentException when name's length is 0, capacity is less than the minimum_capacity and
     *                                  tools is null or the number of tools exceeds the given capacity.
     */
    public ToolRuckSack(final String name, final int capacity, final List<Tool> tools) {
        if (capacity >= MINIMUM_CAPACITY) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("A rucksack must have a capacity!");
        }
        if (tools != null && tools.size() >= MINIMUM_NUM_TOOLS && tools.size() <= capacity) {
            this.tools = new ArrayList<>(capacity);
            this.tools.addAll(tools);
        } else {
            throw new IllegalArgumentException("A rucksack must have tools!");
        }
        if (name != null && name.trim().length() > MINIMUM_LENGTH) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("A rucksack must have name!");
        }
    }

    /**
     * Default constructor if no name and capacity is given.
     *
     * @param tools a list of tools
     */
    public ToolRuckSack(final List<Tool> tools) {
        this(DEFAULT_NAME, DEFAULT_CAPACITY, tools);
    }

    /**
     * Retrieves the elements in the tools one by one (works hand-in-hand with NEXT method).
     *
     * @return an instance of the iterator class
     */
    public Iterator<Tool> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<Tool> {
        /**
         * Index of the next element to return.
         */
        private int cursor;
        Itr() {
        }
        @Override
        public boolean hasNext() {
            return cursor != capacity;
        }

        @Override
        public Tool next() {
            int i = cursor;
            if (i >= capacity) {
                throw new NoSuchElementException();
            }
            if (i >= tools.size()) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return tools.get(i);
        }
    }

    /**
     * Returns the name of the rucksack.
     *
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the maximum capacity of the rucksack.
     *
     * @return capacity as an int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns a description of the rucksack.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "ToolRuckSack{"
                + "tools=" + tools
                + ", name='" + name + '\''
                + ", capacity=" + capacity
                + '}';
    }

    /**
     * Checks if an object is identical to the ruckSack.
     *
     * @param object an object
     * @return true if the object is ruckSack else false
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ToolRuckSack that = (ToolRuckSack) object;
        return capacity == that.capacity && tools.equals(that.tools) && name.equals(that.name);
    }

    /**
     * Returns an int associated with the instance of rucksack.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(tools, name, capacity);
    }
}

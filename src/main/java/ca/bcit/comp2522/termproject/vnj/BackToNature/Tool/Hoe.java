package ca.bcit.comp2522.termproject.vnj.BackToNature.Tool;

/**
 * A hoe tool.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public final class Hoe extends Tool implements UtilityTools {
    /**
     * Default description.
     */
    public static final String DEFAULT_DESCRIPTION = "Use to till farmland for planting Crops and to remove seeds";
    /**
     * Default description.
     */
    public static final int DEFAULT_USAGE = 3;
    /**
     * Default description.
     */
    public static final String DEFAULT_NAME = "Hoe";
    private static Hoe singleInstance = null;

    private Hoe() {
        super(DEFAULT_DESCRIPTION, DEFAULT_NAME, DEFAULT_USAGE);
    }


    /**
     * Creates only one instance of a hoe object.
     *
     * @return an Hoe
     */
    public static Hoe getInstance() {
        if (singleInstance == null) {
            singleInstance = new Hoe();
        }
        return singleInstance;
    }

    /**
     * Tills the soil for the seeds to grow.
     * It can also be used to remove seeds, anywhere really.
     * Thus, always returning true.
     *
     * @return true
     */
    @Override
    public boolean use() {
        return true;
    }
}

package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Plant;
import javafx.scene.canvas.GraphicsContext;

import java.awt.Point;
import java.util.*;

/**
 * Farm Land.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class FarmLand {
    /* Default screen Setting */
    /**
     * Default tile size of the game in pixels.
     */
    public static final int ORIGINAL_TILE_SIZE = 16; // 16x16 tile
    /**
     * Default scale to accommodate with any screen resolutions. (To make images bigger)
     */
    public static final int SCALE = 3;
    /**
     * Default number for the tile size on the game.
     */
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48 tile
    private final HashMap<Point, Soil> soils;
    private final HashMap<Point, Plant> crops;
    private final int rows;
    private final int columns;

    /**
     * Construct an untill and an empty FarmLand object.
     *
     * @param screenWidth the number of rows
     * @param screenHeight the number of columns
     * @throws IllegalArgumentException when size of point is 0 or below
     */
    public FarmLand(final int screenWidth, final int screenHeight) {
        if (screenWidth > 0 && screenHeight > 0) {
            this.rows = screenWidth / TILE_SIZE;
            this.columns = screenHeight / TILE_SIZE;
        } else {
            throw new IllegalArgumentException("A map must have rows and columns!");
        }
        soils = new HashMap<>();
        crops = new HashMap<>();
        getSoilImages();
    }

    /**
     * Populates the soils hashmap with Point and Soil objects and adds images to each soil.
     */
    private void getSoilImages() {
        Point point;
        Soil soil;
        int maxWidth = rows * TILE_SIZE - TILE_SIZE; // max width of the window
        int maxHeight = columns * TILE_SIZE - TILE_SIZE; // max height of the window
        for (int row = maxWidth; row >= 0; row -= TILE_SIZE) {
            for (int column = maxHeight; column >= 0; column -= TILE_SIZE) {
                point = new Point(row, column);
                if (row == 0 || row == maxWidth || column == 0 || column == maxHeight) {
                    soil = new Soil("grass.png", true);
                } else {
                    soil = new Soil("untilledSoil.png", false);
                }
                soils.put(point, soil);
            }
        }
    }

    /**
     * Changes the tile that has been tilled into a tilled soil image.
     *
     * @param point the tile location.
     */
    public void setTillSoilImage(final Point point) {
        if (soils.get(point).getIsFence()) {
            soils.get(point).setImage("tillSoil.png");
        }
    }

    /**
     * Changes the tile that has been tilled into untilled soil image.
     *
     * @param point the tile location.
     */
    public void setUntillSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && soils.get(point).getIsTill()) {
            soils.get(point).setImage("untillSoil.png");
        }
    }

    /**
     * Changes the tile that has been tilled and added seed into seeded till soil image.
     *
     * @param point the tile location.
     */
    public void setSeedTillSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && soils.get(point).getIsTill()) {
            soils.get(point).setImage("tillWithSeeds.png");
        }
    }

    /**
     * Changes the tile that has been tilled and added seed into seeded till soil image.
     *
     * @param point the tile location.
     */
    public void setTurnipSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && crops.containsKey(point)) {
            soils.get(point).setImage("turnipSoil.png");
        }
    }

    /**
     * Changes the tile that has been tilled, seeded and watered into seeded, watered till soil image.
     *
     * @param point the tile location.
     */
    public void setSeedTillWateredSoil(final Point point) {
        if (soils.get(point).getIsFence() && soils.get(point).getIsWatered() && soils.get(point).getIsTill()) {
            soils.get(point).setImage("wateredSeededSoil.png");
        }
    }

    /**
     * Changes the tile that has been watered into a watered soil image.
     *
     * @param point the tile location.
     */
    public void setWaterSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && !soils.get(point).getIsWatered() && soils.get(point).getIsTill()) {
            soils.get(point).setImage("tillSoil.png");
        }
    }

    /**
     * Draws each soil into the map.
     *
     * @param graphicsContext a graphicsContext layout that holds the node images
     */
    public void draw(final GraphicsContext graphicsContext) {
        soils.forEach(((point, soil) -> graphicsContext.drawImage(soil.getImage(), point.x, point.y)));
    }

    /**
     * Returns the points with plants.
     *
     * @return a collection of points
     */
    public Collection<Point> getPointsWithPlants() {
        return crops.keySet();
    }

    /**
     * Tills the soil located on the given point.
     *
     * @param point the location of the soil
     * @return true if a soil was till else false
     */
    public boolean tillSoil(final Point point) {
        Soil soil = soils.get(point);
        if (soil != null) {
            soil.till(true);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Waters the soil located on the given point.
     *
     * @param point the location of the soil
     * @return true if a soil was watered else false
     */
    public boolean waterSoil(final Point point) {
        Soil soil = soils.get(point);
        if (soil != null) {
            soil.water(true);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Drys all the soil.
     */
    public void dryAllSoil() {
        for (Soil soil: soils.values()) {
            if (soil.getIsWatered()) {
                soil.water(false);
            }
        }
    }

    /**
     * Untill all the soil that has not plants.
     */
    public void unTillAllSoil() {
        Set<Point> pointsWithPlants = crops.keySet();
        for (Map.Entry<Point, Soil> soil: soils.entrySet()) {
            if (!pointsWithPlants.contains(soil.getKey()) && soil.getValue().getIsTill()) {
                soil.getValue().till(false);
            }
        }
    }

    /**
     * Plants a crop on the soil.
     *
     * @param point the location of the soil where a plant is planted
     * @param plant the plant.
     */
    public void addPlant(final Point point, final Plant plant) {
        crops.put(point, plant);
    }

    /**
     * Removes the plant from the soil.
     *
     * @param point the location of the plant
     */
    public void removePlant(final Point point) {
        crops.remove(point);
    }

    /**
     * Grows the plant at the end of the day.
     */
    public void growAllPlants() {
        for (Plant plant : crops.values()) {
            plant.grow();
        }
    }

    /**
     * Shows a description about the FarmLand.
     *
     * @return a description
     */
    @Override
    public String toString() {
        return "FarmLand{"
                + "soils=" + soils
                + ", crops=" + crops
                + '}';
    }

    /**
     * Checks if an object is of type FarmLand.
     *
     * @param object an object
     * @return true if an object is of type FarmLand
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FarmLand farmLand = (FarmLand) object;
        return rows == farmLand.rows
                && columns == farmLand.columns
                && soils.equals(farmLand.soils)
                && Objects.equals(crops, farmLand.crops);
    }

    /**
     * Returns a hashcode associated with the instance.
     *
     * @return an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(soils, crops);
    }
}

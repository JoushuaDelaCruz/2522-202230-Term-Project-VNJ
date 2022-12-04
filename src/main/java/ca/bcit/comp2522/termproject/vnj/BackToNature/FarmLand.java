package ca.bcit.comp2522.termproject.vnj.BackToNature;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Plant;
import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Turnip;
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
    /**
     * Default rows where soils will be located.
     */
    public static final int[] ROWS_TO_GROW = {2, 4, 6, 8, 10, 12};
    /**
     * Default columns where soils will be located.
     */
    public static final int[] COLUMNS_TO_GROW = {2, 4, 6, 8, 10, 12};
    /**
     * Default number of days the plant will wilt.
     */
    public static final int DEFAULT_DAYS_TO_WILT = 5;
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
     * Change the soil into a seed soil.
     */
    public void drawCrops() {
        for (int row : ROWS_TO_GROW) {
            for (int column : COLUMNS_TO_GROW) {
                setSeedTillSoilImage(new Point(row * TILE_SIZE, column * TILE_SIZE));
            }
        }
    }

    /**
     * Changes the tile that has been tilled into a tilled soil image.
     *
     * @param point the tile location.
     */
    public void setTillSoilImage(final Point point) {
        int row = (point.x / TILE_SIZE + 1) * TILE_SIZE;
        int column = (point.y / TILE_SIZE + 1) * TILE_SIZE;
        point.setLocation(row, column);
        soils.get(point).setImage("tillSoil.png");
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
     * Dry all soils and resets their image.
     */
    public void drySoils() {
        for (Map.Entry<Point, Plant> plantEntry: crops.entrySet()) {
            soils.get(plantEntry.getKey()).water(false);
            if (plantEntry.getValue().isBudding() && !plantEntry.getValue().getIsWilted()) {
                setBuddingTurnipSoilImage(plantEntry.getKey());
            }
            if (!plantEntry.getValue().isBudding() && !plantEntry.getValue().isRipening()) {
                setSeedTillSoilImage(plantEntry.getKey());
            }
        }
    }

    /**
     * Changes the tile that has been tilled and added seed into seeded till soil image.
     *
     * @param point the tile location.
     */
    public void setSeedTillSoilImage(final Point point) {
        if (soils.get(point).getIsFence()) {
            soils.get(point).setImage("tillWithSeeds.png");
            crops.putIfAbsent(point, new Turnip());
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
        if (soils.get(point).getIsFence() && soils.get(point).getIsWatered()) {
            soils.get(point).setImage("wateredSeededSoil.png");
        }
    }

    /**
     * Changes the image of the plant into a budding stage.
     *
     * @param point the tile location
     */
    public void setBuddingTurnipSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && soils.containsKey(point)) {
            soils.get(point).setImage("BuddingTurnipSoil.png");
        }
    }

    /**
     * Changes the image of the soil into a budding turnip with watered soil.
     *
     * @param point the location of the soil
     */
    public void setBuddingWateredImage(final Point point) {
        if (soils.get(point).getIsFence() && soils.containsKey(point) && crops.get(point).isBudding()) {
            soils.get(point).setImage("BuddingWateredSoil.png");
        }
    }

    /**
     * Changes the image of the plant into a wilted plant.
     *
     * @param point the tile location
     */
    public void setWiltedTurnipSoilImage(final Point point) {
        if (soils.get(point).getIsFence() && soils.containsKey(point) && crops.get(point).isBudding()) {
            soils.get(point).setImage("WiltedTurnipSoil.png");
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
     */
    public void waterSoil(final Point point) {
        int row = (point.x / TILE_SIZE + 1) * TILE_SIZE;
        int column = (point.y / TILE_SIZE + 1) * TILE_SIZE;
        point.setLocation(row, column);
        Soil soil = soils.get(point);
        if (soil != null && crops.containsKey(point) && soil.getIsFence() && !crops.get(point).isRipening()) {
            soil.water(true);
            if (crops.get(point).isBudding() && !crops.get(point).getIsWilted()) {
                setBuddingWateredImage(point);
            } else if (!crops.get(point).isRipening() && !crops.get(point).isBudding()) {
                setSeedTillWateredSoil(point);
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
     * Grows the plant with watered soil and not wilting, at the end of the day. If the soil is not watered
     * after DEFAULT_DAYS_TO_WILT the plant will wilt.
     */
    public void growPlants() {
        for (Map.Entry<Point, Plant> entry : crops.entrySet()) {
            Point point = entry.getKey();
            Plant crop = entry.getValue();
            if (soils.get(point).getIsWatered() && !crop.getIsWilted()) {
                crop.grow();
            } else {
                soils.get(point).soilIsNotWatered();
                if (crop.isBudding()
                        && soils.get(point).getDaysNotWatered() > DEFAULT_DAYS_TO_WILT
                        && !crop.getIsWilted()) {
                    crop.wilt();
                }
            }
        }
    }

    /**
     * Changes image of the plant into their stage.
     */
    public void drawPlants() {
        for (Map.Entry<Point, Plant> entry : crops.entrySet()) {
            Point point = entry.getKey();
            Plant crop = entry.getValue();
            if (crop.isBudding() && !crop.getIsWilted()) {
                setBuddingTurnipSoilImage(point);
            } else if (crop.isRipening() && !crop.getIsWilted()) {
                setTurnipSoilImage(point);
            } else if (crop.getIsWilted()) {
                setWiltedTurnipSoilImage(point);
            }
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

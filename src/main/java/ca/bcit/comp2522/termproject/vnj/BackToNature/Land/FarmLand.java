package ca.bcit.comp2522.termproject.vnj.BackToNature.Land;

import ca.bcit.comp2522.termproject.vnj.BackToNature.Plants.Plant;

import java.awt.Point;
import java.util.*;
import java.util.List;

/**
 * Farm Land.
 *
 * @author Joushua Dela Cruz
 * @version 2022
 */
public class FarmLand {
    private final HashMap<Point, Soil> soils;
    private final HashMap<Point, Plant> crops;

    /**
     * Construct an untill and an empty FarmLand object.
     *
     * @param points a list of points
     * @throws IllegalArgumentException when size of point is 0 or below
     */
    public FarmLand(final List<Point> points) {
        if (points.size() != 0) {
            this.soils = new HashMap<>();
            for (Point point: points) {
                soils.put(point, new Soil());
            }
        } else {
            throw new IllegalArgumentException("A Farm land must have list of points!");
        }
        crops = new HashMap<>();
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
            if (soil.getWater()) {
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
            if (!pointsWithPlants.contains(soil.getKey()) && soil.getValue().getTill()) {
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
        return soils.equals(farmLand.soils) && Objects.equals(crops, farmLand.crops);
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

package boids.rules;

import boids.Boid;
import boids.utils.Vector2D;

/**
 * Represents a rule which bounds boids in a specific rectangle. Useful to force
 * the boids to stay inside the window.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class RuleBoundPosition extends Rule {

    /**
     * The min x-coordinate (left of the bound rectangle).
     */
    private final int xMin;

    /**
     * The max x-coordinate (right of the bound rectangle).
     */
    private final int xMax;

    /**
     * The min y-coordinate (top of the bound rectangle).
     */
    private final int yMin;

    /**
     * The max y-coordinate (bottom of the bound rectangle).
     */
    private final int yMax;

    /**
     * The attraction to keep the boids in the bound rectangle.
     */
    private final int attraction;

    /**
     * Constructor.
     *
     * @param xMin
     * @param xMax
     * @param yMin
     * @param yMax
     */
    public RuleBoundPosition(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;

        this.attraction = 20;
    }

    @Override
    public Vector2D applyRule(Boid boid) {
        Vector2D force = new Vector2D(0, 0);

        double xBoid = boid.getLocation().getX();
        double yBoid = boid.getLocation().getY();

        if (xBoid < xMin) {
            force.setX(attraction);
        } else if (xBoid > xMax) {
            force.setX(-1 * attraction);
        }

        if (yBoid < yMin) {
            force.setY(attraction);
        } else if (yBoid > yMax) {
            force.setY(-1 * attraction);
        }

        return force;
    }

}

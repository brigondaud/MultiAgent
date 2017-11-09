package boids.rules;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

/**
 * Represents a boid that evolves within a 2D boid simulator.
 *
 * @author Baptiste Rigondaud
 *
 */
public class BoidA {

    /**
     * The boid's initial position.
     */
    private Point2D.Float initPosition;

    /**
     * The boid's current position.
     */
    private Point2D.Float position;

    /**
     * The boid's velocity.
     */
    private Point2D.Float velocity;

    /**
     * The maximum width where the boid can move.
     */
    private int maxWidth;

    /**
     * The maximum height where the boid can move.
     */
    private int maxHeight;

    /**
     * Creates a boid which will evolve in a given space with maximum width and
     * height.
     *
     * @param maxWidth The maximum width.
     * @param maxHeight The maximum height.
     */
    public BoidA(int maxWidth, int maxHeight) {
        setMaxWidth(maxWidth);
        setMaxHeight(maxHeight);
    }

    /**
     * Setter for the maxWidth for a boid.
     *
     * @param width
     * @throws IllegalArgumentException if the width is not strictly positive.
     */
    private void setMaxWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be strictly positive");
        }
        this.maxWidth = width;
    }

    /**
     * Setter for the maxHeight for a boid
     *
     * @param height
     * @throws IllegalArgumentException if the height is not strictly positive.
     */
    private void setMaxHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height must be strictly positive");
        }
        this.maxHeight = height;
    }

    /**
     * Getter for the boid's velocity.
     *
     * @return The boid's velocity.
     */
    public Point2D.Float getVelocity() {
        return this.velocity;
    }

    /**
     * Setter for the boid's velocity.
     *
     * @param velocity
     */
    public void setVelocity(Point2D.Float velocity) {
        this.velocity = velocity;
    }

    /**
     * Reset the boid to its initial position.
     */
    public void reset() {
        this.position = initPosition;
    }
}

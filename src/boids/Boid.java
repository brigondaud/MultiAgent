package boids;

import boids.utils.Vector2D;
import boids.utils.GraphicalBoid;
import java.awt.Color;

/**
 * Represents a boid that evolves within a 2D boid simulator.
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 * @version 1.0
 */
public class Boid {

    /**
     * The (x, y)-location at the creation of the boid.
     */
    private final Vector2D initLocation;

    /**
     * The (x, y)-location of the boid in the 2D space.
     */
    private Vector2D location;

    /**
     * The (x, y)-velocity of the boid.
     */
    private Vector2D velocity;

    /**
     * The (x, y)-acceleration of the boid.
     */
    private Vector2D acceleration;

    /**
     * The icon to be drawn to represent the boid and its color.
     */
    private GraphicalBoid icon;
    private final Color fillColor;

    /**
     * The maximum speed of the boid.
     */
    private final double maxSpeed;

    /**
     * The size of the boid.
     */
    private static final int ICON_SIZE = 15;

    /**
     * Constructor of a boid {x, y, fillColor}.
     *
     * @param x The x-coordinate where to place the boid.
     * @param y The y-coordinate where to place the boid.
     * @param fillColor The color to fill in the boid with.
     */
    public Boid(int x, int y, Color fillColor) {
        this.initLocation = new Vector2D(x, y);
        this.restart();

        this.maxSpeed = Double.MAX_VALUE;
        this.fillColor = fillColor;
        this.draw(fillColor);
    }

    /**
     * Constructor of a boid, with max speed {x, y, fillColor, maxSpeed}.
     *
     * @param x The x-coordinate where to place the boid.
     * @param y The y-coordinate where to place the boid.
     * @param fillColor The color to fill in the boid with.
     * @param maxSpeed The maximum speed for a boid.
     */
    public Boid(int x, int y, Color fillColor, double maxSpeed) {
        this.initLocation = new Vector2D(x, y);
        this.restart();

        this.maxSpeed = maxSpeed;
        this.fillColor = fillColor;
        this.draw(fillColor);
    }

    /**
     * Update the velocity and the location of a boid. The update is a simple
     * application of boid rules as they are described in the wording.
     */
    public final void update() {
        Vector2D newLoc = new Vector2D(0, 0);

        this.velocity.add(this.acceleration); // Speed rule application
        this.limitVelocity();

        newLoc.add(this.velocity);

        //Rotate the icon towards its new velocity
        this.icon.rotateTo(this.velocity);

        // Move the icon
        this.icon.translate((int) newLoc.getX(), (int) newLoc.getY());

        this.location.add(this.velocity); // Location rule application
    }

    /**
     * Limit the speed/velocity of the boid.
     *
     * Boids tend to go faster as long as the simulation continues. In real
     * life, animals do not speed up endlessly.
     *
     * This is not a real rule, it is applied after force computation. It
     * normalizes the velocity of the boid with the definied limit.
     */
    public void limitVelocity() {
        double magnitude = this.velocity.magnitude();

        if (magnitude > maxSpeed) {
            this.velocity.divideBy(magnitude);
            this.velocity.multiplyBy(maxSpeed);
        }
    }

    /**
     * Restart the boid. The initial location is restored and the boid is
     * redrawn.
     */
    public final void restart() {
        this.acceleration = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.location = new Vector2D(this.initLocation);

        this.draw(this.fillColor);
    }

    /**
     * Draw the boid.
     *
     * @param fillColor The color to fill in the boid with.
     */
    public final void draw(Color fillColor) {
        this.icon = new GraphicalBoid(location, velocity, Color.gray, fillColor, ICON_SIZE);
    }

    /**
     * Location getter.
     *
     * @return The location of the boid as a 2D vector.
     */
    public Vector2D getLocation() {
        return location;
    }

    /**
     * Velocity getter.
     *
     * @return The velocity of the boid as a 2D vector.
     */
    public Vector2D getVelocity() {
        return velocity;
    }

    /**
     * Acceleration getter.
     *
     * @return The acceleration of the boid as a 2D vector.
     */
    public Vector2D getAcceleration() {
        return acceleration;
    }

    /**
     * Acceleration setter. Once the acceleration is set, everything follows.
     *
     * @param newAcc The new acceleration of the boid.
     */
    public void setAcceleration(Vector2D newAcc) {
        if (newAcc == null) {
            throw new IllegalArgumentException("No null vector!");
        }

        this.acceleration = newAcc;
    }

    /**
     * Get distance between this boid and another one.
     *
     * @param boid The other boid.
     * @return The Euclidean distance between two boids.
     */
    public double getDistance(Boid boid) {
        if (boid == null) {
            throw new IllegalArgumentException("No null boid!");
        }

        return this.location.distanceWith(boid.location);
    }

    /**
     * Icon getter.
     *
     * @return The icon (drawing) of the boid.
     */
    public GraphicalBoid getIcon() {
        return icon;
    }
}

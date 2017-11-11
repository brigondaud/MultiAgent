package boids;

import boids.utils.Vector2D;
import boids.utils.GraphicalBoid;
import java.awt.Color;

/**
 * Represents a boid that evolves within a 2D boid simulator.
 *
 * @author Baptiste Rigondaud
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
    private static final int ICON_SIZE = 10;

    
    public Boid(int x, int y, Color fillColor) {
        this.initLocation = new Vector2D(x, y);
        this.restart();

        this.maxSpeed = Double.MAX_VALUE;
        this.fillColor = fillColor;
        this.draw(fillColor);
    }
    
    public Boid(int x, int y, Color fillColor, double maxSpeed) {
        this.initLocation = new Vector2D(x, y);
        this.restart();

        this.maxSpeed = maxSpeed;
        this.fillColor = fillColor;
        this.draw(fillColor);
    }

    
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
    
    public void limitVelocity() {
        double magnitude = this.velocity.magnitude();
        
        if (magnitude > maxSpeed) {
            this.velocity.divideBy(magnitude);
            this.velocity.multiplyBy(maxSpeed);
        }
    }

    public final void restart() {
        this.acceleration = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.location = new Vector2D(this.initLocation);

        this.draw(this.fillColor);
    }

    public final void draw(Color fillColor) {
        this.icon = new GraphicalBoid(location, velocity, Color.gray, fillColor, ICON_SIZE);
    }

    public Vector2D getLocation() {
        return location;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2D newAcc) {
        if (newAcc == null) {
            throw new IllegalArgumentException("No null vector!");
        }

        this.acceleration = newAcc;
    }

    public double getDistance(Boid boid) {
        if (boid == null) {
            throw new IllegalArgumentException("No null boid!");
        }

        return this.location.distanceWith(boid.location);
    }

    public GraphicalBoid getIcon() {
        return icon;
    }
}

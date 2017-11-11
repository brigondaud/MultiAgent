package boids;

import boids.utils.Vector2D;
import gui.Oval;
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
     * The circle to be drawn to represent the boid.
     */
    private Oval icon;
    private Color fillColor;
    
    private static final int ICON_SIZE = 10;

    
    public Boid(int x, int y, Color fillColor) {
        this.initLocation = new Vector2D(x, y);
        this.restart();
        
        this.fillColor = fillColor;
        this.draw(fillColor);
    }
    
    
    public final void update() {
        Vector2D newLoc = new Vector2D(0, 0);
        
        this.velocity.add(this.acceleration);   // Speed rule application
        newLoc.add(this.velocity);
        
        // Move the icon
        this.icon.translate(
            (int) newLoc.getX(),
            (int) newLoc.getY()
        );
        
        this.location.add(this.velocity);       // Location rule application
    }
    
    public final void restart() {
        this.acceleration = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.location = new Vector2D(this.initLocation);
        
        this.draw(this.fillColor);
    }
    
    public final void draw(Color fillColor) {
        this.icon = new Oval(
            (int) this.location.getX(), (int) this.location.getY(),
            Color.gray, fillColor, ICON_SIZE
        );
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
        if (newAcc == null)
            throw new IllegalArgumentException("No null vector!");
        
        this.acceleration = newAcc;
    }
    
    public double getDistance(Boid boid) {
        if (boid == null)
            throw new IllegalArgumentException("No null boid!");
        
        return this.location.distanceWith(boid.location);
    }

    public Oval getIcon() {
        return icon;
    }
}

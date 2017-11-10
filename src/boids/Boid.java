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
    
    private static final int ICON_SIZE = 10;

    
    public Boid(int x, int y, Color fillColor) {
        this.initLocation = new Vector2D(x, y);
        this.restart();
        
        // Draw the circle to represent the boid
        this.icon = new Oval(
            (int) this.location.getX(), (int) this.location.getY(),
            Color.gray, fillColor, ICON_SIZE
        );
    }
    
    
    public final void update() {
        this.velocity.add(this.acceleration);
        this.location.add(this.velocity);
        
        // TODO LE DESSIN PARLA
    }
    
    public final void restart() {
        this.acceleration = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.location = new Vector2D(this.initLocation);
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

    public Oval getIcon() {
        return icon;
    }
}

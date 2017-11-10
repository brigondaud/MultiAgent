package boids.utils;

/**
 * Represents a 2D Vector.
 * This class may have many applications: location, velocity, acceleration, etc.
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class Vector2D {
    
    /**
     * The x-coordinate for the 2D vector.
     */
    private double x;
    
    /**
     * The y-coordinate for the 2D Vector.
     */
    private double y;

    /**
     * Constructor.
     * 
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Copying constructor.
     * 
     * @param other The boid to copy.
     */
    public Vector2D(Vector2D other) {
        if (other == null)
            throw new IllegalArgumentException("No null vector!");
        
        this.x = other.x;
        this.y = other.y;
    }
    
    
    public void add(Vector2D other) {
        if (other == null)
            return;
        
        this.x += other.x;
        this.y += other.y;
    }
    
    public void minus(Vector2D other) {
        if (other == null)
            return;
        
        this.x -= other.x;
        this.y -= other.y;
    }
    
    public void divideBy(double factor) {        
        this.x /= factor;
        this.y /= factor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x: " + x + ", y: " + y + '}';
    }
}

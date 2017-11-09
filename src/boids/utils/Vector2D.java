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
    private int x;
    
    /**
     * The y-coordinate for the 2D Vector.
     */
    private int y;

    /**
     * Constructor.
     * 
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Copying constructor.
     * 
     * @param other The boid to copy.
     */
    public Vector2D(Vector2D other) {
        this.x = other.x;
        this.y = other.y;
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

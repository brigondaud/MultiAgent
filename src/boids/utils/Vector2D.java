package boids.utils;

/**
 * Represents a 2D Vector. This class may have many applications: location,
 * velocity, acceleration, etc.
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
     * The max angle.
     */
    private static double maxAngle = 2 * Math.PI;

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
        if (other == null) {
            throw new IllegalArgumentException("No null vector!");
        }

        this.x = other.x;
        this.y = other.y;
    }

    public void add(Vector2D other) {
        if (other == null) {
            return;
        }

        this.x += other.x;
        this.y += other.y;
    }

    public void minus(Vector2D other) {
        if (other == null) {
            return;
        }

        this.x -= other.x;
        this.y -= other.y;
    }

    public static Vector2D minus(Vector2D v1, Vector2D v2) {
        if (v1 == null || v2 == null) {
            return null;
        }

        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    public void divideBy(double factor) {
        if (factor == 0)
            throw new ArithmeticException("Divide by zero?!");
            
        this.x /= factor;
        this.y /= factor;
    }
    
    public void multiplyBy(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    /**
     * Computes the angle a vector has to the horizontal.
     *
     * @return the angle to horizontal
     */
    public double angle() {
        double temp = Math.atan2(getY(), getX());
        double angle = temp < 0 ? temp + maxAngle : temp;
        return angle;
    }

    public double distanceWith(Vector2D other) {
        if (other == null) {
            return Double.MAX_VALUE;
        }

        return Math.sqrt(Math.pow(this.x - other.x, 2) * 2 + Math.pow(this.y - other.y, 2));
    }
    
    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) * 2 + Math.pow(this.y, 2));
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

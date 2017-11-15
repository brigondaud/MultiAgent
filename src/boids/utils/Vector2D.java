package boids.utils;

/**
 * Represents a 2D Vector. This class may have many applications: location,
 * velocity, acceleration, etc.
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
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

    /**
     * Add the elements of another vector to this one. If the other vector is
     * null, this method has no effect.
     *
     * @param other The other 2D vector.
     */
    public void add(Vector2D other) {
        if (other == null) {
            return;
        }

        this.x += other.x;
        this.y += other.y;
    }

    /**
     * Subtract the elements of another vector to this one. If the other vector
     * is null, this method has no effect.
     *
     * @param other The other 2D vector.
     */
    public void minus(Vector2D other) {
        if (other == null) {
            return;
        }

        this.x -= other.x;
        this.y -= other.y;
    }

    /**
     * Substract two vectors (v1 - v2) and return the result. If one of the
     * vectors is null, this static method has no effect.
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     * @return The result of v1 - v2.
     */
    public static Vector2D minus(Vector2D v1, Vector2D v2) {
        if (v1 == null || v2 == null) {
            return null;
        }

        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * Divide the vector. If the factor is zero, the division is impossible!
     *
     * @param factor The factor to divide the vector with.
     */
    public void divideBy(double factor) {
        if (factor == 0) {
            throw new ArithmeticException("Divide by zero?!");
        }

        this.x /= factor;
        this.y /= factor;
    }

    /**
     * Multiply the vector.
     *
     * @param factor The factor to multiply the vector with.
     */
    public void multiplyBy(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    /**
     * Compute the angle a vector has to the horizontal.
     *
     * @return The angle to horizontal
     */
    public double angle() {
        double temp = Math.atan2(getY(), getX());
        double angle = temp < 0 ? temp + maxAngle : temp;
        return angle;
    }

    /**
     * Compute the Euclidean distance between this vector and another one. If
     * the other vector is null, +oo is returned.
     *
     * @param other The other vector.
     * @return The Euclidean distance between two Vector2D.
     */
    public double distanceWith(Vector2D other) {
        if (other == null) {
            return Double.POSITIVE_INFINITY;
        }

        return Math.sqrt(Math.pow(this.x - other.x, 2) * 2 + Math.pow(this.y - other.y, 2));
    }

    /**
     * Compute the magnitude of the Vector2D.
     *
     * @return The magnitude.
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) * 2 + Math.pow(this.y, 2));
    }

    /**
     * X getter.
     *
     * @return X
     */
    public double getX() {
        return x;
    }

    /**
     * X setter.
     *
     * @param x New element of the boid location.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Y getter.
     *
     * @return Y
     */
    public double getY() {
        return y;
    }

    /**
     * Y setter.
     *
     * @param y New element of the boid location.
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x: " + x + ", y: " + y + '}';
    }
}

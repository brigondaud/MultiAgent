package boids.utils;

import java.awt.Graphics2D;
import java.awt.Color;
import gui.GraphicalElement;
import java.awt.Polygon;

/**
 * The GraphicalBoid is the graphical element registerd to the gui. The boid is
 * drawn as a triangle that rotates towards its velocity.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class GraphicalBoid implements GraphicalElement {

    /**
     * The boid is represented as a polygon of three points, thus a triangle.
     */
    private Polygon boid;

    /**
     * The boid's location.
     */
    private final Vector2D location;

    /**
     * The x coordinates for the polygon (triangle).
     */
    private final int[] xLocation;

    /**
     * The y coordinates for the polygon (triangle).
     */
    private final int[] yLocation;

    /**
     * *
     * The boid's velocity.
     */
    private Vector2D velocity;

    /**
     * The draw color of the graphical boid.
     */
    private final Color drawColor;

    /**
     * The fill color of the graphical boid.
     */
    private final Color fillColor;

    /**
     * The size of the graphical boid.
     */
    private final int boidSize;

    
    /**
     * Initiates the GraphicalBoid with a location (that will be used to compute
     * the polygon that will be drawn on the gui), a fill and draw color, and a
     * size.
     *
     * @param location  The location on the polygon in the 2D plane.
     * @param velocity  The velocity to represent the orientation.
     * @param drawColor The color to draw the shape of the polygon.
     * @param fillColor The color to fill in the shape with.
     * @param boidSize  The size of the polygon.
     */
    public GraphicalBoid(Vector2D location, Vector2D velocity, Color drawColor, Color fillColor, int boidSize) {
        this.location = location;
        this.velocity = velocity;
        
        this.drawColor = drawColor;
        this.fillColor = fillColor;
        
        this.boidSize = boidSize;
        this.xLocation = new int[3];
        this.yLocation = new int[3];
        
        // Initiates the polygon that will be drawn on the gui.
        computePolygon();
    }

    
    /**
     * Computes the polygon (triangle) that will be drawn on the gui.
     */
    private void computePolygon() {
        // Info about the position of the boid
        int x = (int) location.getX();
        int y = (int) location.getY();
        double angle = velocity.angle();
        
        xLocation[0] = x + (int) (boidSize * Math.cos(angle));
        yLocation[0] = y + (int) (boidSize * Math.sin(angle));
        
        xLocation[1] = x + (int) ((boidSize / 3) * Math.cos(angle + Math.PI / 2));
        yLocation[1] = y + (int) ((boidSize / 3) * Math.sin(angle + Math.PI / 2));
        
        xLocation[2] = x + (int) ((boidSize / 3) * Math.cos(angle - Math.PI / 2));
        yLocation[2] = y + (int) ((boidSize / 3) * Math.sin(angle - Math.PI / 2));

        this.boid = new Polygon(xLocation, yLocation, 3);
    }

    /**
     * Rotates the graphical boid from a given angle.
     *
     * @param newVelocity The new velocity for the polygon.
     */
    public void rotateTo(Vector2D newVelocity) {
        this.velocity = newVelocity;
        computePolygon();
    }

    /**
     * Translates the graphical boid with given dx and dy.
     *
     * @param dx    The translation along the x-axis.
     * @param dy    The translation along the y-axis.
     */
    public void translate(int dx, int dy) {
        boid.translate(dx, dy);
    }

    /**
     * Draws the boid.
     * 
     * @param g2d A graphical instance to paint the polygon.
     */
    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(fillColor);
        g2d.fill(boid);
        g2d.setColor(drawColor);
        g2d.draw(boid);
    }

}

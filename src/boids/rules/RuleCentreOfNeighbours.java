package boids.rules;

import boids.Boid;
import boids.BoidGroup;
import boids.utils.Vector2D;

/**
 * Represents a rule which regroups boids.
 * Useful to encourage boids in a same group to meet.
 * 
 * @author Team 22 in Teide
 * @version 1.0
 */
public class RuleCentreOfNeighbours extends Rule {

    /**
     * The flock to approach.
     *
     * Each boid in the flock will attract the reference boid.
     */
    private final BoidGroup flock;

    /**
     * The maximum distance for attraction. Should be > 0.
     *
     * If not specified, INFINITE.
     */
    private double distance;

    
    /**
     * Constructor of the rule {flock, distance}.
     * 
     * @param flock     The flock to approach as a boid.
     * @param distance  The maximum distance to compose the neighbourhood.
     */
    public RuleCentreOfNeighbours(BoidGroup flock, double distance) {
        this.flock = flock;
        this.setDistance(distance);
    }

    /**
     * Constructor of the rule {flock}.
     * The distance is set to the maximum by default.
     * 
     * @param flock     The flock to approach as a boid.
     */
    public RuleCentreOfNeighbours(BoidGroup flock) {
        this.flock = flock;
        this.distance = Double.MAX_VALUE;
    }

    
    @Override
    public Vector2D applyRule(Boid boid) {
        Vector2D force = new Vector2D(0, 0);

        for (Boid neighbour : flock.getBoids()) {
            if (neighbour != boid && neighbour.getDistance(boid) < this.distance) {
                force.add(neighbour.getLocation());
            }
        }

        if (flock.size() > 1) {
            force.divideBy(flock.size() - 1);
            force.minus(boid.getLocation());
            force.divideBy(100);
        }

        return force;
    }

    /**
     * Distance setter.
     * Should be > 0.
     * 
     * @param distance The new distance for this rule.
     */
    private void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("[Rule] No negative distance.");
        }

        this.distance = distance;
    }
}

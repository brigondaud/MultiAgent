package boids.rules;

import boids.Boid;
import boids.BoidGroup;
import boids.utils.Vector2D;

/**
 * Represents a rule where a boid keeps distance with other boids. Useful to
 * avoid boids overlapping.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class RuleKeepDistance extends Rule {

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
     * @param flock The flock to keep distance with.
     * @param distance The distance to keep.
     */
    public RuleKeepDistance(BoidGroup flock, double distance) {
        this.flock = flock;
        this.setDistance(distance);
    }

    /**
     * Constructor of the rule {flock}. The distance is arbitrarily set to 15 by
     * default.
     *
     * @param flock The flock to keep distance with.
     */
    public RuleKeepDistance(BoidGroup flock) {
        this.flock = flock;
        this.distance = 15;
    }

    @Override
    public Vector2D applyRule(Boid boid) {
        Vector2D force = new Vector2D(0, 0);

        for (Boid neighbour : flock.getBoids()) {
            if (neighbour != boid && neighbour.getDistance(boid) < distance) {
                force.minus(Vector2D.minus(neighbour.getLocation(), boid.getLocation()));
            }
        }

        force.divideBy(5);
        return force;
    }

    /**
     * Distance setter. Should be > 0.
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

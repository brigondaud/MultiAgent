package boids.rules;

import boids.Boid;
import boids.BoidGroup;
import boids.utils.Vector2D;

/**
 * Represents a rule where a boid falls into line with other boids' velocity.
 * Useful to create consistency between boids in a group.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class RuleMatchVelocity extends Rule {

    /**
     * The flock to approach.
     *
     * Each boid in the flock will attract the reference boid.
     */
    private final BoidGroup flock;

    /**
     * Constructor of the rule.
     *
     * @param flock The flock of the boid.
     */
    public RuleMatchVelocity(BoidGroup flock) {
        this.flock = flock;
    }

    @Override
    public Vector2D applyRule(Boid boid) {
        Vector2D force = new Vector2D(0, 0);

        for (Boid neighbour : flock.getBoids()) {
            if (neighbour != boid) {
                force.add(neighbour.getVelocity());
            }
        }

        if (flock.size() > 1) {
            force.divideBy(flock.size() - 1);
            force.minus(boid.getVelocity());
            force.divideBy(5);
        }

        return force;
    }
}

package boids.rules;

import boids.Boid;
import boids.utils.Vector2D;

/**
 * Represents a regulation which can be applied to a boid.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public abstract class Rule {

    /**
     * The application of a rule returns a boid acceleration.
     *
     * @param boid The boid on which the rule will be computed.
     * @return
     */
    public abstract Vector2D applyRule(Boid boid);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boids.rules;

import boids.Boid;
import boids.BoidGroup;
import boids.utils.Vector2D;

/**
 *
 * @author Admin
 */
public class RuleMatchVelocity extends Rule {

    /**
     * The flock to approach.
     * 
     * Each boid in the flock will
     * attract the reference boid.
     */
    private final BoidGroup flock;

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
            force.divideBy(8);
        }
        
        return force;
    }
    
}

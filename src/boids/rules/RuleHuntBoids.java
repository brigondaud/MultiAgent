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
public class RuleHuntBoids extends Rule {
    
    /**
     * The flock to hunt.
     *
     * The boid will hunt one boid in this flock if near enough.
     */
    private final BoidGroup flock;

    /**
     * The maximum distance for hunting.
     * Should be > 0.
     */
    private double distance;
    
    
    public RuleHuntBoids(BoidGroup flock, double distance) {
        this.flock = flock;
        this.setDistance(distance);
    }
    
    
    @Override
    public Vector2D applyRule(Boid boid) {
        Vector2D force = new Vector2D(0, 0);
        
        // About the nearest prey
        Boid nearestPrey = null;
        double nearestDistance = Double.MAX_VALUE;
        
        for (Boid prey : this.flock.getBoids()) {
            double currentDistance = boid.getDistance(prey);
            
            if (prey != boid && currentDistance < this.distance)
                if (currentDistance < nearestDistance) {
                    nearestPrey = prey;
                    nearestDistance = currentDistance;
                }
        }
        
        // Move towards the prey >:-)
        if (nearestPrey != null) {
            force.add(nearestPrey.getLocation());
            force.minus(boid.getLocation());
            force.divideBy(10);
        }
        
        return force;
    }
    
    private void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("[Rule] No negative distance.");
        }

        this.distance = distance;
    }
}

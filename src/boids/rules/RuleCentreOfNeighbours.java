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
public class RuleCentreOfNeighbours extends Rule {
    
    /**
     * The flock to approach.
     * 
     * Each boid in the flock will
     * attract the reference boid.
     */
    private final BoidGroup flock;
    
    /**
     * The maximum distance for attraction.
     * Should be > 0.
     * 
     * If not specified, INFINITE.
     */
    private double distance; 
    

    public RuleCentreOfNeighbours(BoidGroup flock, double distance) {
        this.flock = flock;
        this.setDistance(distance);
    }

    public RuleCentreOfNeighbours(BoidGroup flock) {
        this.flock = flock;
        this.distance = Double.MAX_VALUE;
    }
    
    
    @Override
    public Vector2D applyRule(Boid boid) {
        throw new UnsupportedOperationException("Not supported yet."); // OVR
    }
    
    private void setDistance(double distance) {
        if (distance <= 0)
            throw new IllegalArgumentException("[Rule] No negative distance.");
        
        this.distance = distance;
    }
}

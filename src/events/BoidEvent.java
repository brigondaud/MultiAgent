/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import boids.BoidGroup;

/**
 *
 * @author Admin
 */
public class BoidEvent extends Event {
    
    /**
     * The flock to update when the event fires.
     */
    private final BoidGroup flock;
    
    public BoidEvent(long date, BoidGroup flock) {
        super(date);
        if (flock == null)
            throw new IllegalArgumentException("No null flock in events.");
        
        this.flock = flock;
    }
 
   @Override
    public void execute() {
        this.flock.update();
    }
}

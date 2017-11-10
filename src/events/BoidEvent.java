/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import boids.BoidGroup;
import boids.BoidSystem;

/**
 *
 * @author Admin
 */
public class BoidEvent extends Event {
    
    /**
     * The system in which the event will fire.
     * This reference allows recursion to create events.
     */
    private final BoidSystem system;
    
    /**
     * The flock to update when the event fires.
     */
    private final BoidGroup flock;
    
    public BoidEvent(long date, BoidSystem system, BoidGroup flock) {
        super(date);
        
        if (flock == null || system == null)
            throw new IllegalArgumentException("No null flock in events.");
        
        this.flock = flock;
        this.system = system;
    }
 
    @Override
    public void execute() {
        this.flock.update();
        BoidEvent nextEvent = new BoidEvent(this.getDate() + this.flock.getDelay(), system, flock);
        
        this.system.getEvents().addEvent(nextEvent);
        this.system.executeEvent();
    }
}

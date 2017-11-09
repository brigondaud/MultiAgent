package boids;

import boids.rules.Rule;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a group of boids with its own rules.
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class BoidGroup {
    
    /**
     * The boids taking part of this group.
     */
    private List<Boid> boids;
    
    /**
     * The rules applying on this group.
     */
    private List<Rule> rules;
    
    /**
     * The delay between two updates of the group.
     */
    private final int delay;
    
    /**
     * The width of the window, in pixels.
     */
    private final int width;
    
    /**
     * The height of the window, in pixels.
     */
    private final int height;
    
    
    public BoidGroup(int numberOfBoids, int width, int height) {        
        this.width = width;
        this.height = height;
        this.delay = 1; // TODO.
        
        this.populate(numberOfBoids);
        this.rules = new ArrayList<>();
    }
    
    
    public final void populate(int numberOfBoids) {
        if (numberOfBoids < 1)
            throw new IllegalArgumentException("No empty group of boids.");
        
        Boid futureBoids[] = new Boid[numberOfBoids];         
        Random rand = new Random();

        // Compute three random values for the components
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        // Create the color and make it shiny 8-)
        Color boidColor = new Color(r, g, b).brighter();
            
        for (int i = 0; i < numberOfBoids; ++i) {
            int aleaX = ThreadLocalRandom.current().nextInt(1, height);
            int aleaY = ThreadLocalRandom.current().nextInt(1, width);
            
            futureBoids[i] = new Boid(aleaX, aleaY, boidColor);
        }
        
        // No need to get a mutable list now.
        this.boids = Arrays.asList(futureBoids);
    }    
    
    /**
     * Restarts all boids inside the group.
     */
    public void restart() {
        for (Boid b : boids) b.restart();
    }

    public List<Boid> getBoids() {
        return boids;
    }

    public int getDelay() {
        return delay;
    }
}

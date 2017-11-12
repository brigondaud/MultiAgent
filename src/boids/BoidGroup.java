package boids;

import boids.rules.Rule;
import boids.utils.Vector2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a group of boids with its own rules.
 *
 * @author Team 22 in Teide
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
    private final List<Rule> rules;

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

    
    /**
     * Constructor of a group of boids.
     * 
     * @param numberOfBoids The number of boids inside the group.
     * @param width         The width of the window to init boids.
     * @param height        The height of the window to init boids.
     * @param delay         The delay between two groups events firing.
     */
    public BoidGroup(int numberOfBoids, int width, int height, int delay) {
        this.width = width;
        this.height = height;
        this.delay = delay;

        this.populate(numberOfBoids);
        this.rules = new ArrayList<>();
    }

    /**
     * Update the group of boids with associated rules.
     * If no rules, the update has no effect.
     */
    public void update() {
        Vector2D newAcceleration;

        if (rules.isEmpty())
            return;
        
        // The new boid acceleration will depend on rules.
        for (Boid boid : boids) {
            newAcceleration = new Vector2D(0, 0);

            for (Rule rule : rules) {
                newAcceleration.add(rule.applyRule(boid));
            }

            newAcceleration.divideBy(rules.size());
            boid.setAcceleration(newAcceleration);

            // Once the acceleration is set, the boid is "updatable".
            boid.update();
        }
    }

    /**
     * Fill the new boid group with boids.
     *
     * @param numberOfBoids The number of boids to create.
     */
    public final void populate(int numberOfBoids) {
        if (numberOfBoids < 1) {
            throw new IllegalArgumentException("No empty group of boids.");
        }

        Boid futureBoids[] = new Boid[numberOfBoids];
        Random rand = new Random();

        // Compute three random values for the components
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        // Create the color and make it shiny 8-)
        Color boidColor = new Color(r, g, b).brighter();

        for (int i = 0; i < numberOfBoids; ++i) {
            int aleaX = ThreadLocalRandom.current().nextInt(1, width);
            int aleaY = ThreadLocalRandom.current().nextInt(1, height);

            futureBoids[i] = new Boid(aleaX, aleaY, boidColor, 7);
        }

        // No need to get a mutable list now.
        this.boids = Arrays.asList(futureBoids);
    }

    /**
     * Restarts all boids inside the group.
     */
    public void restart() {
        for (Boid b : boids) {
            b.restart();
        }
    }
    
    /**
     * Add any type of rule to the group.
     * 
     * @param r The new rule.
     * @return The group to allow chains.
     */
    public BoidGroup addRule(Rule r) {
        if (r != null)
            this.rules.add(r);
        
        return this;
    }

    /**
     * Boids getter.
     * 
     * @return The list of boids inside this group.
     */
    public List<Boid> getBoids() {
        return boids;
    }

    /**
     * Number of boids getter.
     * 
     * @return The size of the boids list, the number of boids.
     */
    public int size() {
        return boids.size();
    }

    /**
     * Delay getter.
     * 
     * @return The delay between two updates.
     */
    public int getDelay() {
        return delay;
    }
}

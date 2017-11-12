package boids.rules;

import boids.Boid;
import boids.utils.Vector2D;

/**
 * Represents a rule where a breeze constraints boids movements.
 * Useful to create winds, water flows, etc.
 * 
 * The force of the breeze is a scale between -10 and 10.
 * There is two scales : a vertical one and an horizontal one.
 * 
 * The balance is available with (0, 0) (no breeze).
 * 
 * (-10, -10) |  (10, -10)
 * -----------|-----------
 * (-10, 10)  |   (10, 10)
 * 
 * @author Team 22 in Teide
 * @version 1.0
 */
public class RuleStiffBreeze extends Rule {

    /**
     * The horizontal force factor to move boids in {-10, 10}.
     */
    private final double horizontalBreezeFactor;
    
    /**
     * The vertical force factor to move boids in {-10, 10}.
     */
    private final double verticalBreezeFactor;
    
    
    /**
     * Constructor of the rule {hBF, vBF}.
     * 
     * @param hBF   The horizontal breeze factor (in {-10, 10}).
     * @param vBF   The vertical breeze factor (in {-10, 10}).
     */
    public RuleStiffBreeze(double hBF, double vBF) {

        if (hBF > 10 || hBF < -10 || vBF > 10 || vBF < -10)
            throw new IllegalArgumentException("Breeze factors not in {-10, 10}");
        
        this.horizontalBreezeFactor = hBF;
        this.verticalBreezeFactor = vBF;
    }
    
    
    @Override
    public Vector2D applyRule(Boid boid) {        
        return new Vector2D(
            0.05 * horizontalBreezeFactor,
            0.05 * verticalBreezeFactor
        );
    }
    
}

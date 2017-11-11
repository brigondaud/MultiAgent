/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import boids.BoidGroup;
import boids.BoidSystem;
import boids.rules.*;

/**
 *
 * @author Admin
 */
public class TestBoidHunting {

    public static void main(String[] args) {
        BoidSystem bs = new BoidSystem(900, 600);
        BoidGroup predators = bs.addGroupOf(4, 2);
        BoidGroup preys = bs.addGroupOf(15, 1);
    
        preys.addRule(new RuleCentreOfNeighbours(preys)).addRule(new RuleKeepDistance(preys))
             .addRule(new RuleMatchVelocity(preys)).addRule(new RuleBoundPosition(0, 900, 0, 600))
             .addRule(new RuleKeepDistance(predators, 50));
        
        predators.addRule(new RuleKeepDistance(predators)).addRule(new RuleHuntBoids(preys, 500))
                 .addRule(new RuleBoundPosition(0, 900, 0, 600));
        
        bs.simulate();
    }
    
}

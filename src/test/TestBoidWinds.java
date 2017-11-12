package test;

import boids.BoidGroup;
import boids.BoidSystem;
import boids.rules.RuleBoundPosition;
import boids.rules.RuleCentreOfNeighbours;
import boids.rules.RuleKeepDistance;
import boids.rules.RuleMatchVelocity;
import boids.rules.RuleStiffBreeze;

/**
 *
 * @author Team 22 in Teide
 */
public class TestBoidWinds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoidSystem bs = new BoidSystem(900, 600);
        BoidGroup g1 = bs.addGroupOf(50, 1);

        g1.addRule(new RuleCentreOfNeighbours(g1)).addRule(new RuleKeepDistance(g1))
            .addRule(new RuleMatchVelocity(g1)).addRule(new RuleBoundPosition(0, 900, 0, 600));

        g1.addRule(new RuleStiffBreeze(-6, 6));

        bs.simulate();
    }

}

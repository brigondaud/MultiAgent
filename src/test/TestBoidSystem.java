package test;

import boids.BoidGroup;
import boids.BoidSystem;
import boids.rules.RuleBoundPosition;
import boids.rules.RuleCentreOfNeighbours;
import boids.rules.RuleKeepDistance;
import boids.rules.RuleMatchVelocity;

/**
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 */
public class TestBoidSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoidSystem bs = new BoidSystem(900, 600);
        BoidGroup g1 = bs.addGroupOf(150, 1);
        BoidGroup g2 = bs.addGroupOf(50, 1);

        g1.addRule(new RuleCentreOfNeighbours(g1)).addRule(new RuleKeepDistance(g1))
            .addRule(new RuleMatchVelocity(g1)).addRule(new RuleBoundPosition(0, 900, 0, 600));

        g2.addRule(new RuleCentreOfNeighbours(g2)).addRule(new RuleKeepDistance(g2))
            .addRule(new RuleMatchVelocity(g2)).addRule(new RuleBoundPosition(0, 900, 0, 600));

        // Keep distance between two groups.
        g1.addRule(new RuleKeepDistance(g2, 40));
        g2.addRule(new RuleKeepDistance(g1, 40));

        bs.simulate();
    }
}

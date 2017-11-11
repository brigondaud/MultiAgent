package boids.rules;

import boids.BoidGroup;

/**
 * The RuleFactory can create rules that will be applied to flocks. This is a
 * case of factory design pattern.
 *
 * @author Baptiste Rigondaud
 *
 */
public class RuleFactory {

    /**
     * This rule creation method only creates the three basic rules for the
     * flocks and flocks.
     *
     * @param ruleName the rule to create
     * @param flock the flock on which the rule is applied
     * @param distance the maximum distance of the rule application
     * @return the created rule
     * @throws IllegalArgumentException if the rule does not exists
     */
    public static final Rule createBasicRule(String ruleName, BoidGroup flock, double distance) {
        Rule rule;
        switch (ruleName) {
            case "CentreOfNeighbours":
                rule = new RuleCentreOfNeighbours(flock, distance);
                break;
            default:
                throw new IllegalArgumentException("Rule does not exist");
        }
        return rule;
    }

}

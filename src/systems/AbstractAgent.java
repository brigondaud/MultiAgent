package systems;

/**
 * Represents the agent in a multiagent system environment.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
abstract public class AbstractAgent {
    
    /*
        Motivations for an AbstractAgent class
        --------------------------------------
    
        The purpose of this class is to create
        a link between automata cells and boids
        which are two agents in multiagent systems.
    
        These subclasses have a location in common.
        Yet we chose to model the locations differently
        (vector vs. (i, j) pair) so there is
        nothing to factorize here.
    
        Moreover, there's always an intermediate between
        our systems and their agents (grids, groups, ...).
    */
}
